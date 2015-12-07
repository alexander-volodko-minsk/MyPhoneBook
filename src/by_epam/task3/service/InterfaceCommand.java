package by_epam.task3.service;

import by_epam.task3.bean.TO.Request;
import by_epam.task3.bean.TO.Response;

public interface InterfaceCommand 
{
    Response execute(Request request);
}
