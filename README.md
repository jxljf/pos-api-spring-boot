# pos-api

此代码为 `TDD与重构` 和 `Web MVC / Restful` 的随堂练习。

业务说明参见 https://github.com/XLuoChen/pos-page/blob/master/README.md

请使用 git 将代码克隆后，实现缺失的部分代码，最终通过测试。

## 依赖

- JDK >=8 (下述二选一)
  - [OpenJDK](https://adoptopenjdk.net/upstream.html)
  - [Oracle JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
- IDE
  - [IDEA Community](https://www.jetbrains.com/idea/download/)
  - [Eclipse](https://www.eclipse.org/downloads/)

## 克隆代码

```bash
git clone https://github.com/zaypen-community-sharing/pos-api.git
```

## 完成代码

### 《TDD与重构》 章节

默认 master 分支

下述两个方法需要被完成

- src/main/java/com/thoughtworks/course/pos/service/CartService.java 的 `mergeBarcodes` 方法
- src/test/java/com/thoughtworks/course/pos/service/PromotionServiceTest.java 的 `shouldDiscount2When7InChart` 方法

### 《Web MVC / Restful》 章节

检出 api 分支

```bash
git checkout api
```

下述两个方法需要被完成

- com/thoughtworks/course/pos/service/OrderService.java 的 getDiscountPrice 方法
- com/thoughtworks/course/pos/service/OrderController.java 的 getOrders 方法

启动 Spring Boot 程序

```bash
./gradlew bootRun # macOS/Linux
gradlew.bat test # Windows
```

访问 pos-page 页面

[http://localhost:8080](http://localhost:8080)

## 执行测试

macOS/Linux

```bash
./gradlew test
```

Windows

```bat
gradlew.bat test
```
