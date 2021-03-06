package com.forsrc.cxf.server.restful.base.webservice;

import com.forsrc.cxf.server.restful.base.vo.Page;
import com.forsrc.exception.ServiceException;
import org.apache.cxf.jaxrs.ext.PATCH;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * The interface Base cxf action.
 *
 * @param <E>  the type parameter
 * @param <PK> the type parameter
 */
@Path(value = "/v1.0/api")
//@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
//WebService
public interface BaseCxfWebService<E, PK> {

    /**
     * Get e.
     *
     * @param id the id
     * @return the e
     * @throws ServiceException the service exception
     */
    @GET
    @Path("/{id}")
    //@WebMethod
    //@RequestWrapper()
    //@ResponseWrapper(targetNamespace = "http://pojo.forsrc.com")
    //@WebResult(name = "return", targetNamespace = "http://webservice.book.restful.server.cxf.forsrc.com")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public E get(@PathParam("id") PK id) throws ServiceException;

    /**
     * List page.
     *
     * @return the page
     * @throws ServiceException the service exception
     */
    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Page<E> list(
                        //@FormParam("start") Integer start
                        //, @FormParam("size") Integer size
                        //@Context HttpServletRequest servletRequest
                        //, @Context HttpServletResponse servletResponse
    ) throws ServiceException;

    /**
     * Save e.
     *
     * @param e the e
     * @return the e
     * @throws ServiceException the service exception
     */
    @POST
    @Path("")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public E save(E e) throws ServiceException;

    /**
     * Update e.
     *
     * @param id the id
     * @param e  the e
     * @return the e
     * @throws ServiceException the service exception
     */
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public E update(@PathParam("id") PK id, E e) throws ServiceException;

    /**
     * Patch e.
     *
     * @param id the id
     * @param e  the e
     * @return the e
     * @throws ServiceException the service exception
     */
    @PATCH
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public E patch(@PathParam("id") PK id, E e) throws ServiceException;

    /**
     * Delete response.
     *
     * @param id the id
     * @return the response
     * @throws ServiceException the service exception
     */
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") PK id) throws ServiceException;

}
