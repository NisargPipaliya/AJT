### Here we donot create main method or object for the servlet, then how does the methods inside it runs?
- Here the webserver creates object for the servlet and calls the methods.

### how is the mapping done?
- There is a config.property file in side which it is written as:
    `/urlpattern_defined_by_us = package_name.servlet_class_name`
    `example: /helloworld = my_package.MyServlet`
    To Read this config file
```Java
InputStream in = getClass().getClassLoader().getResourceAsStream(configFileName);
Properties props = new Properties();
props.load(in);
props.forEach((key,value) -> {
    // task to be done
})
```