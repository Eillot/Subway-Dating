# Subway Dating

#### 项目介绍
基于Restful风格的社交app软件 server端

#### 软件架构
使用Spring Boot+MVC+Facade软件架构，后期根据需要调整.


#### 安装教程

1. 本地下载并安装JDK 1.8 redis 2.4.5 MySQL 8.0.11
2. 执行SQL创建本地数据库与表，字段.
3. 启动项目开始构建.

#### Server端实现功能说明

1. 基于Jwt token认证机制，实现用户操作模块，主要有：用户登录，注册，认证等主要功能.
2. 基于mysql实现用户信息查询，修改，保存与读取图片（使用保存图片路径的方式）.
3. 集成redis 保存高频率查询修改数据，提升性能.
4. 定时同步mysql的数据到redis ,若redis数据失效，则主动向mysql发起数据同步.
5. 用户权限管理
#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

####
开源协议： Apache License-2.0

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

请勿用商业用途，侵权必究.
####