package br.com.apolomcmelo.hackerrank;

import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Client {
    public static void main(String[] args) throws IOException, IntrospectionException, InstanceNotFoundException, MalformedObjectNameException, ReflectionException {
       
        MBeanServerConnection connection = getConnection("192.168.250.83", 4380);
        
//        writeAttributes(connection, new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME));
        loadMonitoringObjects(connection);
    }

    private static MBeanServerConnection getConnection(String host, int port) {
        try {
            String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";

            JMXServiceURL serviceUrl = new JMXServiceURL(url);
            JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);

            MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();

            return connection;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void loadMonitoringObjects(MBeanServerConnection connection) {
        try {
            AttributeList memAttributes = connection.getAttributes(new ObjectName(ManagementFactory.MEMORY_MXBEAN_NAME), new String[] {"HeapMemoryUsage"});
            AttributeList opSysAttributes = connection.getAttributes(new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME), new String[] {"ProcessCpuLoad"});
//            AttributeList gcAttributes = connection.getAttributes(new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE), new String[] {"HeapMemoryUsage"});
            CompositeData memory = ((CompositeData)(((Attribute) memAttributes.get(0)).getValue()));
            Attribute cpu = (Attribute) opSysAttributes.get(0);
            System.out.println("Máx: " + memory.get("max") + " Used: " + memory.get("used"));
            System.out.println("Memória utilizada: " + calculateMemoryUsage((long)memory.get("max"), (long)memory.get("used")) + "%");
            System.out.println("CPU utilizado: " + calculateCpuUsage((double)cpu.getValue()) + "%");
        } catch (MalformedObjectNameException | InstanceNotFoundException | ReflectionException | IOException e) {
            //Log exception
            e.printStackTrace();
        }
    }

    private static double calculateCpuUsage(double value) {
        if (value == -1.0) {
            return Double.NaN;
        }

        return ((value * 1000.0) / 10.0);
    }
    
    private static double calculateMemoryUsage(long maxMemory, long usedMemory) {
        Double FATOR_MB = 1024.0*1024.0;

        return ((usedMemory/FATOR_MB) * 100.0) / (maxMemory / FATOR_MB);
    }
     
    
    private static void writeAttributes(final MBeanServerConnection mBeanServer, final ObjectName http)
                    throws InstanceNotFoundException, IntrospectionException, ReflectionException, IOException {
        MBeanInfo info = mBeanServer.getMBeanInfo(http);
        MBeanAttributeInfo[] attrInfo = info.getAttributes();

        System.out.println("Attributes for object: " + http + ":\n");
        for (MBeanAttributeInfo attr : attrInfo) {
            System.out.println("  " + attr.getName());
        }
    }
    
}
