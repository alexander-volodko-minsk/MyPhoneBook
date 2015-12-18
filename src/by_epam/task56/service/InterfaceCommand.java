package by_epam.task56.service;

import by_epam.task56.bean.to.Request;
import by_epam.task56.bean.to.Response;
import by_epam.task56.service.impl.ServiceException;

public interface InterfaceCommand 
{
    Response execute(Request request) throws ServiceException;
}
