# Personal AI Chatbot Client

An Android application built using Kotlin and Jetpack Compose to interact with a personal AI chatbot hosted on a Genezio server.

## Project Overview

This project aims to create a lightweight and intuitive mobile client for personal AI interactions. The backend integrates with Gemini through a custom-built API.

## Features

- Real-time chat with a personal AI chatbot
- User profile and notifications screen
- Clean and responsive UI with Jetpack Compose
- Smooth navigation using Jetpack Navigation
- Communication with a custom API hosted on Genezio

## Tech Stack

- **Android:** Kotlin, Jetpack Compose, Jetpack Navigation
- **API Communication:** Retrofit
- **Backend Server:** Genezio (TypeScript or Python)
- **AI Provider:** Gemini API

## Project Structure

```
main/
└── java/
└── com/
└── example/
└── privatellmchat/
├── data/
│   ├── api/
│   │   ├── AuthentificationApi.kt
│   │   └── ChatApi.kt
│   └── repository/
│       ├── AuthRepository.kt
│       └── ChatRepository.kt
├── di/
│   └── NetworkModule.kt
├── ui/
│   ├── screens/
│   │   ├── chat/
│   │   │   └── ChatScreen.kt
│   │   ├── login/
│   │   │   └── LoginScreen.kt
│   │   └── profile/
│   │       └── ProfileScreen.kt
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Theme.kt
│   │   ├── ThemeViewModel.kt
│   │   └── Type.kt
│   └── viewModel/
│       └── SharedViewModel.kt
└── MainActivity.kt
```

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/personal-ai-chatbot-client.git
   ```
2. Open the project in Android Studio.
3. Configure the server URL inside the Retrofit service.
4. Run the project on an emulator or physical device.

## License

This project is licensed under the MIT License.

