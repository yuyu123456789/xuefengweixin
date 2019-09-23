package com.shareluntan.xuefeng.config;

import lombok.Data;


    @Data
    public class ResponseClass {

        private boolean isok; // 请求是否成功
        private int code;        // http status code
        private String message; //请求失败的的提示信息。
        private Object data;     //请求成功时，需要响应给前端的数据

        private ResponseClass() {

        }
        //请求出现异常时的响应数据封装
        public static ResponseClass error(CustomException e) {

            ResponseClass resultBean = new ResponseClass();
            resultBean.setIsok(false);
            resultBean.setCode(e.getCode());
            if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
                resultBean.setMessage(e.getMessage() + ",用户异常");
            }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
                resultBean.setMessage(e.getMessage() + ",服务器异常，请联系王雪峰找出问题");
            }else{
                resultBean.setMessage("系统出现未知异常!");
            }
            return resultBean;
        }
        //请求成功时的响应数据封装，没有响应数据（比如删除修改成功）
        public static ResponseClass success() {
            ResponseClass resultBean = new ResponseClass();
            resultBean.setIsok(true);
            resultBean.setCode(200);
            resultBean.setMessage("success");
            return resultBean;
        }
        //请求成功时的响应数据封装，有响应数据（比如查询成功）
        public static ResponseClass success(Object data) {
            ResponseClass resultBean = new ResponseClass();
            resultBean.setIsok(true);
            resultBean.setCode(200);
            resultBean.setMessage("success");
            resultBean.setData(data);
            return resultBean;
        }

    }

