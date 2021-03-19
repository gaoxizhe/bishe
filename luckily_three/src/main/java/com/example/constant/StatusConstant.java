package com.example.constant;

/**
 * Created by Donghua.Chen on 2018/4/29.
 */
public interface StatusConstant {

    interface Common {
        static final Integer SUCCESS = 0;
        static final Integer ERROR = 1001;
        static final String SUCCESS_MSG = "请求成功";
        static final String ERROR_MSG = "请求失败";
        static final String PARAM_IS_EMPTY = "参数为空";
        static final String DELETE_ERROR = "删除错误";
        static final String INVALID_PARAM = "无效的参数";
        static final String CAN_NOT_FIND_PARAM_TO_CONTIUNE = "找不到参数继续运行";
        static final String OBJECT_IS_EMPTY = "找不到参数继续运行";


    }

    interface Label {
        static final Integer DELETE_FAIL_CODE = 1051;
        static final String DELETE_FAIL = "存在已使用本标签的文章，删除失败！";

    }

    interface Category {
        static final Integer DELETE_FAIL_CODE = 1061;
        static final String DELETE_FAIL = "存在已使用本分类的文章，删除失败！";

    }

    interface Att {
        static final String ADD_NEW_ATT_FAIL = "添加附件信息失败";
        static final String UPDATE_ATT_FAIL = "更新附件信息失败";
        static final String DELETE_ATT_FAIL = "删除附件信息失败";
        static final String UPLOAD_FILE_FAIL = "上传附件失败";
    }

    interface Comment {
        static final String ADD_NEW_COMMENT_FAIL = "添加评论失败";
        static final String UPDATE_COMMENT_FAIL = "更新评论失败";
        static final String DELETE_COMMENT_FAIL = "删除评论失败";
        static final String COMMENT_NOT_EXIST = "评论不存在";
    }

    interface Option {
        static final String DELETE_OPTION_FAIL = "删除配置失败";
        static final String UPDATE_OPTION_FAIL = "更新配置失败";
    }

    interface Meta {
        static final String ADD_META_FAIL = "添加项目信息失败";
        static final String UPDATE_META_FAIL = "更新项目信息失败";
        static final String DELETE_META_FAIL = "删除项目信息失败";
        static final String NOT_ONE_RESULT = "获取的项目的数量不止一个";
        static final String META_IS_EXIST = "该项目已经存在";
    }

    interface Auth {
        static final String USERNAME_PASSWORD_IS_EMPTY = "用户名和密码不可为空";
        static final String USERNAME_PASSWORD_ERROR = "用户名不存在或密码错误";
        static final String NOT_LOGIN = "用户未登录";
        static final String USERNAME_IS_EXIST = "用户名已经存在";
    }

    interface Mail {
        static final String MAIL_IS_EXIST = "邮箱已经存在";
        static final String MAIL_CODE_FAIL = "邮箱验证码错误";
        static final String MAIL_CODE_DIFFERENT = "邮箱验证码不匹配";
    }
}
