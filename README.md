# GameProject

## I. Phần đồ họa cần thêm các hình sau
### 1. Hình PNG 16x16 px
-  Nhân vật chuyển động: 2 ảnh chạy lên, 2 ảnh chạy xuống, 2 ảnh chạy sang trái, 2 ảnh chạy sang phải (có thể tham khảo hình t đang lấy tạm ở thư mục res/player)
-  Ô vuông mặt phẳng để ghép map: đường đi, cỏ, cây, đá,... tùy ý sáng tạo ạ, c vẽ xong note lại là loại ô nào đi xuyên qua được nhé
-  Mini monster: tầm 3-4 loại
-  Hiệu ứng tấn công của nv chính (quả cầu bay ra hoặc gì đó)
-  Vật phẩm khác: tiền xu, lá may mắn, 1 loại trái cây hoặc nấm nào đó (để ăn vào được buff thêm hp á), trái tim 

### 2. Thanh HP, thanh năng lượng tích lũy: rộng khoảng 16px, dài tùy ý (chiều rộng màn chơi là 256px nha)

(t định để 2 thanh ở phía trên, mỗi thanh 1 màu (VD như thanh HP thì có hình trái tim, thanh năng lượng thì hình tia chớp chẳng hạn :v)

Nếu vẽ đc thì mỗi thanh c vẽ 5 mức năng lượng nhá từ 0 đến 4, kiểu như chạm 1 con monster thì sẽ -1 vạch, ăn 1 quả gì đó thì +1 vạch HP, ăn đc 10 xu thì đc đánh boss 1 lần í 

### 3. Con Boss 24x24px
Có bao nhiêu boss thì bấy nhiêu màn chơi á:))) Ban đầu bảo 7 màn hơi tham vọng :V

### 4. Ma trận cho bản đồ
Ngoài ra phần map cần thêm ma trận để vẽ bản đồ í, sau khi vẽ xong c đánh số cho mỗi loại địa hình và ghép thành map tương ứng, sau đó làm 1 ma trận cho map ấy luôn nha (ngang 16 ô - dọc 12 ô) (có thể tham khảo trong src/Tile/map.txt)

### 5. Ảnh cho phần mở màn và kết thúc nếu có thời gian (và muốn)

## II. Phần code
Tham khảo playlist này ạ:
https://www.youtube.com/watch?v=oPzPpUcDiYY&list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq&index=7

## III. Lưu ý:
Mọi người gửi username git để tớ thêm vào contributors nhá, t cũng mới biết dùng git sơ sơ nma nếu mn chưa biết chỗ nào t có thể chỉ được trong phạm vi cần thiết(mn biết cả thì tốt quá ạ huhu).
