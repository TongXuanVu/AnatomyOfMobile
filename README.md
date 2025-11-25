# AnatomyOfMobile# AndroidAuthApp - Ứng Dụng Đăng Nhập/Đăng Ký Cơ Bản (Kotlin & SQLite)

## 🌟 Giới Thiệu

**AndroidAuthApp** là một ứng dụng di động Android cơ bản được phát triển bằng ngôn ngữ Kotlin, nhằm mục đích minh họa cách triển khai chức năng đăng nhập và đăng ký người dùng. Dữ liệu người dùng (tên đăng nhập và mật khẩu) được lưu trữ cục bộ trên thiết bị bằng cơ sở dữ liệu **SQLite**.

Dự án này cũng được cấu hình để sử dụng **R8/ProGuard** nhằm tối ưu hóa và thu nhỏ mã nguồn khi build bản Release.

## ✨ Tính Năng Chính

*   **Đăng ký Tài khoản:** Cho phép người dùng tạo tài khoản mới.
    *   *Lưu ý:* Tên đăng nhập được xác thực chỉ cho phép chữ cái và số để ngăn chặn các lỗi logic và bảo mật.
*   **Đăng nhập:** Xác thực người dùng dựa trên thông tin lưu trữ trong SQLite.
*   **Lưu trữ Cục bộ:** Sử dụng SQLite để lưu trữ dữ liệu người dùng trên thiết bị.
*   **Bảo mật Cơ bản:** Sử dụng cơ chế tham số hóa trong truy vấn SQLite để ngăn chặn lỗi SQL Injection.
*   **Tối ưu hóa Mã:** Cấu hình R8/ProGuard cho bản Release.

## 🛠️ Công Nghệ Sử Dụng

*   **Ngôn ngữ:** Kotlin
*   **Nền tảng:** Android (API 24+)
*   **Cơ sở dữ liệu:** SQLite (Android built-in)
*   **Build Tool:** Gradle
*   **Tối ưu hóa:** R8/ProGuard

## 🚀 Hướng Dẫn Cài Đặt và Chạy Dự Án

### Yêu cầu

*   **Android Studio** (Phiên bản mới nhất được khuyến nghị)
*   **Java Development Kit (JDK) 17** hoặc **JDK 19** (Được cấu hình trong Android Studio)

### Các bước thực hiện

1.  **Clone Repository:**
    ```bash
    git clone https://github.com/TongXuanVu/AnatomyOfMobile
    cd AndroidAuthApp
    ```

2.  **Mở Dự án:**
    *   Mở **Android Studio**.
    *   Chọn **File > Open...** và điều hướng đến thư mục `AndroidAuthApp` vừa clone.

3.  **Đồng bộ hóa Gradle:**
    *   Android Studio sẽ tự động đồng bộ hóa. Nếu không, nhấn vào biểu tượng **"Sync Project with Gradle Files"** (biểu tượng con voi xanh).

4.  **Chạy Ứng Dụng:**
    *   Chọn thiết bị ảo (Emulator) hoặc thiết bị thật.
    *   Nhấn nút **Run** (biểu tượng tam giác màu xanh lá cây).

### Hướng dẫn Sử dụng Ứng dụng

1.  Ứng dụng khởi động ở màn hình **Đăng nhập**.
2.  Nhấn **"Đăng ký ngay"** để tạo tài khoản mới.
3.  Sử dụng tài khoản vừa tạo để **Đăng nhập**.
4.  Sau khi đăng nhập thành công, bạn sẽ được chuyển đến màn hình **Chào mừng**.

## 👥 Thông Tin Nhóm Phát Triển

Dự án này được phát triển bởi nhóm sinh viên:

| Tên Thành viên | Mã số Sinh viên | Email|
| :--- | :--- | :--- |
| Kim Thái Vi Anh | 23520045 | 23520045@gm.uit.edu.vn |
| Phan Nguyễn Huy Duy | 23520385 | 23520385@gm.uit.edu.vn |
| Nguyễn Đức Hiếu | 23520483 | 23520483@gm.uit.edu.vn |
| Tống Xuân Vũ| 23521817 |23521817@gm.uit.edu.vn |

---

