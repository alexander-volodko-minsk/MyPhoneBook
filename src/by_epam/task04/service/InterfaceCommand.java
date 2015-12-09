package by_epam.task04.service;

import by_epam.task04.bean.to.Request;
import by_epam.task04.bean.to.Response;

public interface InterfaceCommand 
{
    Response execute(Request request);
}
