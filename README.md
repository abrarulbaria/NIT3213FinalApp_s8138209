# NIT3213 Final App – s8138209

This Android app was developed for the NIT3213 unit using Kotlin and follows clean architecture principles. It allows users to log in using their first name and student ID, and then displays topic data based on their assigned keypass from a remote API.

---

## 🔐 Login Page
- Students log in with their first name and student ID.
- Keypass is extracted and used to fetch dynamic dashboard data.


  <img width="202" alt="image" src="https://github.com/user-attachments/assets/c114c6bc-febf-4c9c-9640-503361ddc216" />

  ## 📋 Dashboard Page
- Displays a list of items based on the student's keypass.
- Each item is clickable and navigates to a detail screen.



  <img width="182" alt="image" src="https://github.com/user-attachments/assets/107155ad-61bb-47ed-a7e1-347f402da349" />


  ## 🧾 Details Page
- Shows full information about the selected item from the dashboard.
- All data is fetched dynamically from the API response.


<img width="205" alt="image" src="https://github.com/user-attachments/assets/e70cfb1f-e28f-4196-94cc-496b134400dc" />

## 📁 Project Structure

```plaintext
NIT3213FinalApp_s8138209/
├── .gitignore
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── local.properties
├── settings.gradle.kts
├── app/
│   ├── .gitignore
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/
│   │   │   │   └── com/example/nit3213finalapp_s8138209/
│   │   │   │       ├── DashboardActivity.kt
│   │   │   │       ├── DetailActivity.kt
│   │   │   │       ├── LoginActivity.kt
│   │   │   │       ├── MainActivity.kt
│   │   │   │       ├── TopicAdapter.kt
│   │   │   │       └── TopicItem.kt
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── ic_launcher_background.xml
│   │   │   │   │   ├── ic_launcher_foreground.xml
│   │   │   │   │   └── welcome_image.png
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_dashboard.xml
│   │   │   │   │   ├── activity_detail.xml
│   │   │   │   │   ├── activity_login.xml
│   │   │   │   │   └── item_topic.xml
│   │   │   │   └── values/
│   │   │   │       ├── colors.xml
│   │   │   │       ├── strings.xml
│   │   │   │       └── themes.xml



API Integration
The app fetches data from:

https://nit3213api.onrender.com/dashboard/{keypass}
API returns dynamic data (e.g. architecture, food, etc.)

Works for any student with a valid keypass.

 Features
Secure login with user-based keypass
 Live API data fetch (not hardcoded)
Clean and responsive UI
Reusable adapter for dynamic data display

 Developer
Name: Abrarul Baria

Student ID: s8138209






