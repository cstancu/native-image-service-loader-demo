package service;

import java.util.ServiceLoader;

public class ServiceLoaderTest {
    public static void main(String[] args) {
        ServiceLoader<ServiceBase> services = ServiceLoader.load(ServiceBase.class);
        System.out.println("services.iterator().hasNext() = " + services.iterator().hasNext());

        for (ServiceBase service : services) {
            System.out.println("service implementation = " + service.getClass());
        }
    }
}
