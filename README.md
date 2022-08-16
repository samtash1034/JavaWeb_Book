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
* 在你的Mysql中，創建一個名稱為 資料庫 的資料庫，並導入 .sql 文件
* 修改jdbc.properties配置文件，把資料庫帳號和密碼，改為自己的
* 把src/main資料夾底下的內容複製到專案底下
* 配置tomcat
* 運行

# 功能介紹

### 1、分頁功能及分頁詳細訊息
* 如果當前頁為第一頁則無法點擊上一頁和首頁
* 如果當前頁為最後一頁則無法點擊下一頁和末頁
* 如果有新增或刪除則分頁詳細訊息都會隨之改動

![分頁](https://user-images.githubusercontent.com/82807965/182617293-5e30796f-6ee5-4118-bcef-62976a006f6d.jpg)

### 2、新增
* 點擊新增進行會員的新增
* 注意用戶名格式及不可重複
* 注意信箱格式
![新增](https://user-images.githubusercontent.com/82807965/182618356-e774b456-617f-4ba6-addb-1d22bd692aba.jpg)
![用戶名可用](https://user-images.githubusercontent.com/82807965/182620041-3937c960-9bc9-4d7e-8c31-235aff6d5948.jpg)
![用戶名格式錯誤](https://user-images.githubusercontent.com/82807965/182620135-7b325163-e942-4de7-9a08-a9840a609e3f.jpg)
![用戶名重複](https://user-images.githubusercontent.com/82807965/182620142-bee94c82-4675-443d-a6ee-8a534b9bc701.jpg)
![信箱格式錯誤](https://user-images.githubusercontent.com/82807965/182620169-a1412ba9-524c-4a54-9b01-537a3745731b.jpg)

### 3、編輯
* 除了姓名以外其他皆可編輯
* 注意信箱格式
* ![編輯](https://user-images.githubusercontent.com/82807965/182620550-32b1c265-25e7-4293-821f-280a830dc73a.jpg)

### 4、刪除

* 單項刪除

![單項刪除](https://user-images.githubusercontent.com/82807965/182621287-52257dd8-f080-4168-b17b-00300c211680.jpg)

* 批量刪除(可點擊全選框全選或再按一次取消全選)

![批量刪除](https://user-images.githubusercontent.com/82807965/182621300-89d92ae3-4d3c-490b-b6a5-95d3b7928c23.jpg)






