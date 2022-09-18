# RestTemplateEX



作品說明
1. 呼叫 coindesk API,解析其下行內容與資料轉換,並實作新的 API。
coindesk API:https://api.coindesk.com/v1/bpi/currentprice.json



2. 建立一張幣別與其對應中文名稱的資料表(需附建立 SQL 語法),並提
供 查詢 / 新增 / 修改 / 刪除 功能 API；使用Spring MVC架構實作。




資料夾說明
1. controller--針對H2DB的CRUD API，共4個；提供呼叫 coindesk API的解析其下行內容與資料轉換後結果的新API，共1個。
2. coindeskAPI--處理呼叫 coindesk API的解析其下行內容與資料轉換。
3. model--包含幣別的pojo及串接H2DB進行資料CRUD的部分。
4. service --接續model層級controller層。




測試資料夾說明
1. coindeskAPI--內容是呼叫 coindesk API,並顯示其內容。
2. controller--內容含測試呼叫資料轉換的 API,並顯示其內容測試；測試查詢 / 新增 / 修改 / 刪除 功能 API。
