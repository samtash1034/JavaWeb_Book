# 簡介
使用Jsp+Servlet+MySQL建立線上書店

# 使用技術

* Jsp
* Servlet
* 資料庫連接池：druid 
* jQuery
* Ajax
* Gson
* Kaptcha驗證碼
* 資料庫：MySQL


# 快速上手
### 1、運行環境和所需工具
* 編譯器：IntelliJ IDEA
* 數據庫：MySQL 8.0
* JDK版本：jdk1.8
* Tomcat版本：Tomcat9.X

### 2、初始化項目
* 在你的Mysql中，創建一個名稱為 資料庫 的資料庫，並導入 book.sql 文件
* 修改jdbc.properties配置文件，把資料庫帳號和密碼，改為自己的
* 把src/main資料夾底下的內容複製到專案底下
* 配置tomcat
* 運行

# 頁面及功能介紹

### 1、首頁
* 登入成功會顯示帳號
* 當前購物車為空則會提醒您
* 添加商品會顯示目前購物車商品數量及最後一次添加的商品

![首頁](https://user-images.githubusercontent.com/82807965/185012683-94113f89-f423-4ac6-8bfd-23e86ddd0bd1.jpg)
![登入成功首頁](https://user-images.githubusercontent.com/82807965/185014204-ed09a24b-de5d-4a2e-a8e3-d299f89eb795.jpg)
![首頁添加商品](https://user-images.githubusercontent.com/82807965/185013884-59cb97b0-be6c-48a6-921f-950142aefe7b.jpg)


### 2、登入功能
* 會提示輸入帳號和密碼
* 登入失敗會提示並保留當初輸入的帳號

![登入頁面](https://user-images.githubusercontent.com/82807965/185014497-524cc788-aa3d-4c7b-b01c-88d6c13109d5.jpg)
![登入失敗](https://user-images.githubusercontent.com/82807965/185014506-6be2eac2-1cb6-48c4-9aa8-5cd05bff4075.jpg)












