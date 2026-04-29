# 好学云课堂（HaoXue Cloud Classroom）

在线职业教育平台 —— 基于 Spring Cloud 微服务架构的全栈项目。

## 项目简介

好学云课堂是一个面向职业教育的在线学习平台，提供课程管理、学习记录、考试测评、优惠促销、支付交易等完整业务闭环。项目采用微服务架构，涵盖高并发秒杀、分布式缓存、异步消息、分布式调度等核心场景。

## 技术栈

| 类别 | 技术 |
|---|---|
| 基础框架 | Spring Boot 2.7、Spring Cloud 2021、Spring Cloud Alibaba |
| 注册/配置中心 | Nacos |
| 网关 | Spring Cloud Gateway |
| 服务调用 | OpenFeign + Ribbon |
| 数据库 | MySQL 8.0 + MyBatis-Plus |
| 缓存 | Redis + Redisson + Caffeine（两级缓存） |
| 消息队列 | RabbitMQ + DelayQueue |
| 分布式锁 | Redisson |
| 分布式调度 | XXL-Job |
| 搜索引擎 | Elasticsearch 7.12 |
| 支付 | 支付宝沙箱 + 微信支付 |
| 对象存储 | 腾讯云 COS + VOD |
| 权限认证 | JWT + 自定义鉴权 SDK |
| 接口文档 | Knife4j |
| 容器化 | Docker |

## 模块说明

```
hxkt-cloud
├── hxkt-api          -- 内部服务调用API模块
├── hxkt-auth         -- 权限认证服务
│   ├── hxkt-auth-common        -- 认证公共模块
│   ├── hxkt-auth-gateway-sdk   -- 网关鉴权SDK
│   ├── hxkt-auth-resource-sdk  -- 资源鉴权SDK
│   └── hxkt-auth-service       -- 认证服务实现
├── hxkt-common       -- 公共模块（工具类、自动配置等）
├── hxkt-course       -- 课程服务
├── hxkt-data         -- 数据看板服务
├── hxkt-exam         -- 考试服务
├── hxkt-gateway      -- API网关
├── hxkt-learning     -- 学习中心服务
├── hxkt-media        -- 媒资服务
├── hxkt-message      -- 消息服务
│   ├── hxkt-message-api        -- 消息API模块
│   ├── hxkt-message-domain     -- 消息领域模块
│   └── hxkt-message-service    -- 消息服务实现
├── hxkt-pay          -- 支付服务
│   ├── hxkt-pay-api            -- 支付API模块
│   ├── hxkt-pay-domain         -- 支付领域模块
│   └── hxkt-pay-service        -- 支付服务实现
├── hxkt-promotion    -- 促销/优惠券服务
├── hxkt-remark       -- 点赞/互动服务
├── hxkt-search       -- 搜索服务
├── hxkt-trade        -- 交易/订单服务
└── hxkt-user         -- 用户服务
```

## 项目亮点

### 1. 高并发秒杀/领券系统
- 使用 Redis Lua 脚本保证原子性操作，防止超卖和超领
- Redisson 分布式锁防止并发冲突
- RabbitMQ 异步解耦，削峰填谷

### 2. 海量数据签到与排行榜系统
- Redis Bitmap 实现高效签到记录存储
- Redis ZSet 实现实时积分排行榜
- XXL-Job 定时任务生成历史赛季榜单

### 3. 高并发视频播放进度同步
- Caffeine + Redis 两级缓存减少数据库压力
- DelayQueue 延迟批量写入，合并高频更新请求
- Lua 脚本保证缓存与数据库一致性

### 4. 独立点赞与互动服务架构
- Redis Set 存储点赞关系，ZSet 统计点赞数
- Redis Pipeline 批量查询点赞状态
- 读写分离 + 异步同步架构

### 5. 统一鉴权与网关架构
- Spring Cloud Gateway 全局鉴权过滤器
- 自定义鉴权 SDK 供各微服务接入
- JWT Token 解析 + 权限校验

## 快速开始

### 环境要求
- JDK 11+
- MySQL 8.0+
- Redis 6.0+
- Nacos 2.x
- RabbitMQ 3.8+
- Elasticsearch 7.12+
- XXL-Job 2.3+

### 配置说明
敏感配置已使用环境变量占位，启动前需配置以下环境变量：

| 环境变量 | 说明 |
|---|---|
| `ENCRYPT_KEYSTORE_PASSWORD` | 证书库密码 |
| `ENCRYPT_KEYSTORE_SECRET` | 证书库秘钥 |
| `TENCENT_SECRET_ID` | 腾讯云 SecretId |
| `TENCENT_SECRET_KEY` | 腾讯云 SecretKey |
| `TENCENT_VOD_URL_KEY` | 腾讯云 VOD URL Key |
| `ALI_SMS_ACCESS_ID` | 阿里云短信 AccessId |
| `ALI_SMS_ACCESS_SECRET` | 阿里云短信 AccessSecret |
| `ALI_PAY_APP_ID` | 支付宝 AppId |
| `ALI_PAY_MERCHANT_PRIVATE_KEY` | 支付宝商户私钥 |
| `ALI_PAY_PUBLIC_KEY` | 支付宝公钥 |
| `WX_PAY_APP_ID` | 微信支付 AppId |
| `WX_PAY_MCH_ID` | 微信支付商户号 |
| `WX_PAY_MCH_SERIAL_NO` | 微信支付证书序列号 |
| `WX_PAY_PRIVATE_KEY` | 微信支付私钥 |
| `WX_PAY_API_V3_KEY` | 微信支付 V3 密钥 |

### 启动步骤
1. 启动 Nacos、MySQL、Redis、RabbitMQ、Elasticsearch 等基础服务
2. 在 Nacos 中配置各共享配置文件（shared-spring.yaml、shared-redis.yaml 等）
3. 按以下顺序启动微服务：
   - `hxkt-gateway`（网关）
   - `hxkt-auth`（认证服务）
   - `hxkt-user`（用户服务）
   - 其他业务服务

## 许可证

本项目仅供学习交流使用。
