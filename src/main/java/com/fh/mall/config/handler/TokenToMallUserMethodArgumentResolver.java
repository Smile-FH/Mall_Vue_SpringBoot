package com.fh.mall.config.handler;

import com.fh.mall.common.MallException;
import com.fh.mall.common.ServiceResultEnum;
import com.fh.mall.config.annotation.TokenToMallUser;
import com.fh.mall.dao.MallUserMapper;
import com.fh.mall.dao.MallUserTokenMapper;
import com.fh.mall.entity.MallUser;
import com.fh.mall.entity.MallUserToken;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * Description: 参数解析器配置类
 *
 * @Author: HueFu
 * @Date: 2020-8-31 22:28
 */
@Component
public class TokenToMallUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private MallUserTokenMapper mallUserTokenMapper;

    @Resource
    private MallUserMapper mallUserMapper;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 如果参数使用了@TokenTomallUser注解才执行本类的验证方法
        if (methodParameter.hasParameterAnnotation(TokenToMallUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 为啥要判断所用的注解是不是TokenToMallUser的子类啊？
        if (methodParameter.getParameterAnnotation(TokenToMallUser.class) instanceof TokenToMallUser) {
            MallUser mallUser = null;
            // 获取请求中携带的token值
            String token = nativeWebRequest.getHeader("token");
            // 如果拿到的数据不是空，那就接着往下判断token是否过期，先拿到token所属的mallUser用户，然后再比较当前时间和数据库中的到期时间 提问：如果token没有往数据库中存储的时候该怎么去比较？
            if (null != token && !"".equals(token) && 32 == token.length() ) {
                // 从数据库中查token所属的User
                MallUserToken mallUserToken = mallUserTokenMapper.selectByPrimaryToken(token);
                // 1. 查不到mallUserToken，因为没有相同的token，也就是：令牌出错了，得重新登录
                if (mallUserToken == null || mallUserToken.getExpireTime().getTime() < System.currentTimeMillis()){
                    // 抛个异常出来，告诉客户端重新登录
                    MallException.fail(ServiceResultEnum.TOKEN_EXPIRE_ERROR.getResult());
                }else {
                    // 如果查到的当前token那么就根据id查询当前用户数据
                    mallUser = mallUserMapper.selectByPrimaryKey(mallUserToken.getUserId());
                    if (mallUser == null) {
                        MallException.fail(ServiceResultEnum.USER_NULL_ERROR.getResult());
                    }
                    // 判断用户是否被封
                    if (mallUser.getLockedFlag().intValue() == 1) {
                        MallException.fail(ServiceResultEnum.USER_LOCKED_ERROR.getResult());
                    }
                    return mallUser;
                }
            }
            else {
                // 如果获得为空，直接抛未登录异常出去
                MallException.fail(ServiceResultEnum.USER_NOT_LOGIN.getResult());
            }
        }
        return null;
    }



}
