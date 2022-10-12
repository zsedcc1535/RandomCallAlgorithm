# 项目环境及结构

- 编程语言：java
- 工具：intellij idea

#### 项目结构

- pojo包用以存放实体类
  - 存放在包含学生所有信息的Student类

- data包用以生成数据集

  - RandInfo用以随机生成学生的性别，年龄，绩点等信息

  - RandAttendance用以随机生成缺课的成员名单

  - CreateData生成完整的数据集

- algorithm包用以取出数据和完成点名算法

  - GetData用于取出数据
  - RandomCall用以点名并生成输出E的值

- 使用时运行RandomCall类即可

#### 功能描述

 最小化向后端发送的请求次数，最大化抓出缺勤同学的数量
