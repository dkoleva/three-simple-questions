module com.three.simple.questions.backend {

    requires spring.beans;
    requires spring.boot;
    requires spring.web;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.data.mongodb;
    requires spring.data.commons;

    exports com.three.simple.questions.backend.web;
}