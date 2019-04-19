# Subway Dating

项目介绍
基于Restful风格的server端Subway Dating

软件架构
框架主体：


Spring Boot（即Spring + SpringMVC + MyBatis）

项目设计结构：

1.DAO层用于封装数据库操作，包括查询，修改，删除，数据同步等.

2.ENGINE层用于封装通用方法，包括安全，鉴权，工具，数据加密同步等操作.

3.FACADE层用于封装传输层与显示层数据，屏蔽掉ENGINE层对数据的复杂操作,提高安全性.

4.SERVICE层用于封装暴露给外界调用的服务接口，方便外界接入测试平台.

5.WEB层用于封装资源展示逻辑控制方法，使前端数据展示更加美观得体.


#### Server端已实现部分功能说明

1. 基于Jwt token认证机制，实现用户操作模块，主要有：用户登录，注册，认证等主要功能.
2. 基于mysql实现用户信息查询，修改，保存与读取图片（使用保存图片路径的方式）.
3. 集成redis 保存高频率查询修改数据，提升性能.
4. 定时同步mysql的数据到redis ,若redis数据失效，则主动向mysql发起数据同步.
5. 用户权限管理

安装教程
本地下载并安装JDK 1.8 ,redis-3.2.5,IDEA 2018与 MySQL 8.0
clone代码到本地,执行SQL创建本地数据库表字段.
使用Maven启动项目并开始构建.
构建完毕后，在浏览器中输入URL访问服务.
使用说明
一. 环境配置

MySql篇

1.下载并安装Mysql

(1)下载地址

MySQL-8.0下载地址

(2)Mysql配置

1.home目录下命令行执行：vi    .bash_profile来配置MySql绝对路径

2.MySql配置如下:

Setting PATH for MySql 8.0.15

    # Setting PATH for Python 3.7
    #The original version is saved in .bash_profile.pysave
    PATH="/Library/Frameworks/Python.framework/Versions/3.7/bin:${PATH}"

    #########################################
    #mysql 环境变量如下
    export PATH=${PATH}:/usr/local/mysql/bin
    export PATH
    #########################################

    alias python="/Library/Frameworks/Python.framework/Versions/3.7/bin/python3.7"

    if [ -f ~/.git-completion.bash ]; then
      . ~/.git-completion.bash
    fi
配置完毕后，保存并退出.

命令行执行:
#mysql -u root -p #使用root权限登陆mysql

#create user 'diting'@'localhost' identified by 'diting'; #使用root创建mysql用户diting密码为diting

#CREATE     DATABASE    diting; #创建数据库diting

#show    databases; #查看root创建的数据库中包含diting

#grant all privileges on diting.* to 'diting'@'localhost'; #root授权给用户diting对数据库diting操作的所有权限

#quit #退出root权限

#mysql -u diting -p #使用用户diting登陆mysql

#执行建表语句:

   create table dt_image
   (
     id          bigint auto_increment
       primary key,
     image_name  varchar(200) null,
     image_path  varchar(500) null,
     create_time timestamp    null,
     constraint dt_image_image_name_uindex
       unique (image_name)
   );

   create table dt_user
   (
     id            bigint auto_increment
       primary key,
     user_account  varchar(50)  not null,
     user_password varchar(50)  not null,
     create_time   timestamp    not null,
     user_emails   varchar(50)  null,
     user_roles    varchar(50)  null,
     user_token    varchar(500) not null,
     constraint dt_user_user_account_uindex
       unique (user_account)
   );
#Mysql命令行所有命令执行完毕

F&Q&A

1.mysql对大小写敏感，输入SQL语句时注意大小写;

2.在为数据库谛听创建table时，注意一定记得切换为用户diting来创建，否则需要root授权.

3.在命令行执行建表语句时，SQL语句可能因为语法问题而无法执行,推荐使用IDEA来建表,很简单这里不在赘述.

Java篇

1.下载并安装java jdk 1.8.0_191及以上版本

2.配置JDK环境变量与JRE执行环境,很简单这里不在赘述.

Redis篇

1.下载并安装Redis-3.2.5 Redis-3.2.5下载地址

2.安装完毕后，命令行执行

#cd /usr/local/redis-3.2.5/

#open -p redis.conf

#将redis.conf文件中的"#requirepass foobared"去掉注释，foobared替换为123456，保存并退出. #继续执行如下命令:

#cd /usr/local/redis-3.2.5/src/

#./redis-server    #启动redis服务

#./redis-cli    #另开命令行窗口在同一目录下启动client端

#auth 123456    #执行redis认证,返回OK表示redis密码设置成功

#至此项目执行环境搭建完毕

二. 项目执行

1.下载并安装IDEA

2.下载代码到本地，使用IDEA导入

3.待依赖加载完毕后，右击diting-web模块的DitingWebApplication.java，来启动使用postman 创建post/get请求即可

用户注册接口---案例:

1.使用postman创建post请求:

URL为：http://127.0.0.1:8080/api/v1/user/register

求的json数据为:

               {
                "userLoginAccount": "zq3",
                "userLoginPassword": "134242"
               }
用户注册接口返回json数据为:

{
    "status": "200",
    "code": "200",
    "msg": "register success",
    "data": 
    {
        "appToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6cTMiLCJyb2xlcyI6Ik1FTUJFUiIsImV4cCI6MTU1MTA4MTMyOCwiaWF0IjoxNTUwNDc2NTI4fQ.-eCz5BzdEqR4z8sfLRoq6NzZsqun8In8if4ZIvgl85U6dKnzQxjxJBxzNfzjMy2jubQEqlL5Dv-ddI_l_d-JHw",
        "appKey": "api token"
    }
}
F&Q&A

1.记得设置下mac 版postman默认的请求响应时间在postman--->Preferences--->Request timeoput in ms(0 for infinity)的默认值,避免postman过早判断接口响应超时,推荐3600ms


参与贡献
Fork 本项目
新建 Feat_xxx 分支
提交代码
新建 Pull Request
Wiki编辑说明风格约定为Markdown风格

####
开源协议： Apache License-2.0

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

请勿用商业用途，侵权必究.
####
