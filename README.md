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
* 點擊或輸入頁碼則會跳到指定的頁碼，若當前為第一頁則不會顯示首頁及上一頁，最後一頁反之亦然

![首頁](https://user-images.githubusercontent.com/82807965/185015996-862f9353-6b15-4669-b75b-b08905825b85.jpg)
![登入成功首頁](https://user-images.githubusercontent.com/82807965/185014204-ed09a24b-de5d-4a2e-a8e3-d299f89eb795.jpg)
![首頁添加商品](https://user-images.githubusercontent.com/82807965/185013884-59cb97b0-be6c-48a6-921f-950142aefe7b.jpg)


### 2、登入功能
* 會提示輸入帳號和密碼
* 登入失敗會提示並保留當初輸入的帳號

![登入頁面](https://user-images.githubusercontent.com/82807965/185014497-524cc788-aa3d-4c7b-b01c-88d6c13109d5.jpg)
![登入失敗](https://user-images.githubusercontent.com/82807965/185014506-6be2eac2-1cb6-48c4-9aa8-5cd05bff4075.jpg)

### 3、註冊功能
* 帳號一輸入完則會立即判斷是否可用
* 密碼不一致，或是帳號、信箱格式、驗證碼輸入錯誤一樣會提示
* 點擊驗證碼可變換

![帳號可用](https://user-images.githubusercontent.com/82807965/185015448-92fba121-9b9b-4fb7-91ab-b3b7980a7cc4.jpg)
![帳號重複](https://user-images.githubusercontent.com/82807965/185015457-6d2436bd-e30c-4ff8-9378-06435c34c8ac.jpg)
![密碼不相同-2](https://user-images.githubusercontent.com/82807965/185015462-90c27ff1-3759-45e9-b8c3-1ebde5c8d58a.jpg)
![信箱格式錯誤](https://user-images.githubusercontent.com/82807965/185015473-19f46ea7-d625-4bc1-b5ba-2281f0858c68.jpg)
![驗證碼錯誤](https://user-images.githubusercontent.com/82807965/185015476-2f538e7d-8fcb-4880-a97d-19d2a7d69667.jpg)

### 4、購物車
* 顯示商品數量及總金額
* 可修改購買的商品數量，金額也會隨之變動
* 刪除商品及清空購物車皆會提示

![購物車](https://user-images.githubusercontent.com/82807965/185016546-6a51e667-152a-4eef-aaea-ff6c5635b895.jpg)
![修改商品數量](https://user-images.githubusercontent.com/82807965/185016551-b9c8e996-8acc-49e2-adaa-c0f9edc4f7ef.jpg)
![刪除商品](https://user-images.githubusercontent.com/82807965/185016555-9817e88d-6eff-4a15-a3c4-44db50438596.jpg)
![清空購物車](https://user-images.githubusercontent.com/82807965/185016559-aaa06fa9-17a1-40aa-ae49-73ec29078310.jpg)

### 5、結帳
* 會生成隨機的訂單編號
* 結帳過後購物車的商品會全部清空(會給提示方便跳轉到首頁購買商品)

![結帳](https://user-images.githubusercontent.com/82807965/185016902-2100c524-b671-46c9-9b0a-4eed9e881125.jpg)
![購物車清空](https://user-images.githubusercontent.com/82807965/185016876-9742564c-1b1c-46a3-bda3-4203342331e7.jpg)

*** 6、後台功能
* 一樣有分頁功能
* 點擊後台管理會跳到後台，如果沒登入則會直接跳轉到登入頁面(這裡尚未實現用戶和管理員的權限設置)
* 後台實現新增、編輯、刪除功能

![後台分頁](https://user-images.githubusercontent.com/82807965/185018221-0c405a0c-163a-4096-aacf-09120cca50d0.jpg)
![編輯圖書](https://user-images.githubusercontent.com/82807965/185018231-51a18b25-a5f2-4482-b13f-3e8393deedf9.jpg)
![儲存圖書](https://user-images.githubusercontent.com/82807965/185018239-3486bda2-1579-41c6-82cf-1d706a004b86.jpg)
![刪除圖書](https://user-images.githubusercontent.com/82807965/185018250-e784c531-311a-45db-af85-1ad8db18280f.jpg)















