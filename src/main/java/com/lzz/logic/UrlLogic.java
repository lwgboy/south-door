package com.lzz.logic;

import com.lzz.dao.IUrlDao;
import com.lzz.model.Response;
import com.lzz.model.UrlModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lzz on 2018/2/4.
 */
@Component
public class UrlLogic {
    @Resource
    IUrlDao urlDao;

    public Response addUrl(String showName, String url, int proxyPort) {
        UrlModel urlModel = new UrlModel(showName, url, proxyPort);
        Response response = Response.Fail();
        if (urlDao.add(urlModel) == true) {
            response = Response.Success();
        }
        return response;
    }

    public Response removeUrl(String showName) {
        return urlDao.delete(showName) == true ? Response.Success() : Response.Fail();
    }

    public Response urlList() {
        List<UrlModel> urlList = urlDao.urlList();
        return new Response(0, "success", urlList);
    }
}
