package com.hy.crm.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.User;
import com.hy.crm.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class RealmDemo extends AuthorizingRealm{
    @Autowired
    private IUserService userService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*Object object=principalCollection.getPrimaryPrincipal();
        //调用数据库查询用户名
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user",object);
        User user=userService.getOne(queryWrapper);
        QueryWrapper<User_Jurisdiction> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("uid",user.getNumber());
        List<User_Jurisdiction> list=userJurisdictionService.list(queryWrapper1);
        List<Jurisdiction> jurisdictionList=new ArrayList<>();
        for(User_Jurisdiction user_jurisdiction:list){
            Jurisdiction jurisdiction=jurisdictionService.getById(user_jurisdiction.getJid());
            jurisdictionList.add(jurisdiction);
        }
        Set<String> permission=new HashSet<String>();
        for(Jurisdiction jurisdiction:jurisdictionList){
            permission.add(jurisdiction.getTitle());
        }
        Set<String> roles=new HashSet<String>();
        roles.add("sss");
        //3、返回授权的信息类
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.addStringPermissions(permission);*/
        return null;
    }
    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("number",usernamePasswordToken.getUsername());
        User user=userService.getOne(queryWrapper);
        if(user==null){
            throw  new UnknownAccountException("此用户不存在");
        }
        SimpleAuthenticationInfo simpleAuthorizationInfo=new SimpleAuthenticationInfo(usernamePasswordToken.getUsername(),usernamePasswordToken.getPassword(),getName());
       /* SimpleAuthenticationInfo simpleAuthenticationInfo;
        //将传过来的AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        //调用数据库查询用户名
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user",usernamePasswordToken.getUsername());
        User user=userService.getOne(queryWrapper);
        //密码加密加盐
       ByteSource byteSource=ByteSource.Util.bytes(user.getUser());
        //返回认证信息由父类 AuthenticatingRealm 进行认证
        if(user!=null){
             simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUser(), user.getPassword(),byteSource, getName());
        }else{
             simpleAuthenticationInfo = new SimpleAuthenticationInfo("-1", "0cb506c8c95a66e87c463bf1a270446c",byteSource, getName());
        }*/

        return simpleAuthorizationInfo;
    }
    //MD5加密
    public static void main(String[] args){
        String hashAlgorithmName = "MD5";//加密方式
        Object credentials = "123456789";//要加密的密码
        Object salt = ByteSource.Util.bytes("admin");//加的盐
        int hashIterations = 1024;//加密次数
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}
