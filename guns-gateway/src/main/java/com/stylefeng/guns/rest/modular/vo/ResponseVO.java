package com.stylefeng.guns.rest.modular.vo;

import lombok.Data;

@Data
public class ResponseVO<M> {
    private int status;
    private String msg;
    private M data;
    private String imgPre;
    private int nowPage;
    private int totalPage;

    public static<M> ResponseVO success(int nowPage, int totalPage, String imgPre, M m)  {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setImgPre(imgPre);
        responseVO.setNowPage(nowPage);
        responseVO.setTotalPage(totalPage);
        responseVO.setData(m);

        return responseVO;
    }


    private ResponseVO() {}

    public static<M> ResponseVO success(String imgPre, M m)  {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setImgPre(imgPre);
        responseVO.setData(m);

        return responseVO;
    }

    public static<M> ResponseVO success(M m)  {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(m);

        return responseVO;
    }

    public static<M> ResponseVO success(String msg)  {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setMsg(msg);

        return responseVO;
    }

    public static<M> ResponseVO serviceFail(String msg)  {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg(msg);

        return responseVO;
    }

    public static<M> ResponseVO appFail(String msg)  {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(999);
        responseVO.setMsg(msg);

        return responseVO;
    }

}
