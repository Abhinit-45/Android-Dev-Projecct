# ServiceConnect - Android App

A modern Android application built with Kotlin that connects customers with local service providers, similar to Urban Company but focused on facilitating connections rather than direct service provision.

## 🏗️ Project Overview

ServiceConnect is a platform app that allows customers to find and connect with local service providers. The app charges only a nominal visiting fee (like OLX model) and enables direct communication and price negotiation between customers and providers.

## ✨ Key Features

### For Customers
- **Browse Services**: Explore various service categories (Plumber, Electrician, Carpenter, etc.)
- **Find Providers**: Search and filter service providers by location, rating, and price
- **Direct Communication**: Chat directly with providers to discuss requirements
- **Request Visits**: Schedule provider visits with transparent visiting charges
- **Track Bookings**: Manage upcoming and past service requests
- **Rate & Review**: Share feedback about service providers

### For Service Providers
- **Provider Registration**: Complete profile setup with skills and availability
- **Manage Bookings**: Handle service requests and customer communications
- **Set Availability**: Configure working hours and service areas
- **Build Reputation**: Collect reviews and ratings from customers

## 🎨 UI/UX Design Highlights

### Modern Material Design
- **Clean Interface**: Consistent use of Material Design 3 components
- **Professional Color Scheme**: Primary blue (#2196F3) with orange accents (#FF5722)
- **User-Friendly Navigation**: Bottom navigation with intuitive icons
- **Responsive Layout**: Optimized for various screen sizes

### Key Screens
1. **Splash Screen**: Attractive loading screen with app branding
2. **Home Screen**: Service categories grid with search functionality
3. **Search Screen**: Advanced filtering and provider discovery
4. **Provider Profile**: Detailed provider information with reviews
5. **Chat Interface**: Real-time messaging between customers and providers
6. **Booking Flow**: Step-by-step visit scheduling with cost transparency
7. **My Bookings**: Comprehensive booking management
8. **User Profile**: Account settings and navigation hub
9. **Provider Signup**: Complete registration form for service providers

## 🛠️ Technical Implementation

### Architecture
- **Language**: Kotlin
- **UI Framework**: XML Layouts with Material Design Components
- **Navigation**: Bottom Navigation with Fragment-based architecture
- **Image Loading**: Glide for efficient image handling
- **Styling**: Comprehensive theming with custom colors and styles

### Project Structure
```
app/
├── src/main/
│   ├── res/
│   │   ├── layout/           # UI layouts for activities and fragments
│   │   ├── values/           # Colors, strings, and styling resources
│   │   ├── drawable/         # Icons and background drawables
│   │   ├── menu/            # Navigation menus
│   │   └── color/           # Color state selectors
│   └── java/               # Kotlin source code (to be implemented)
├── build.gradle.kts        # App-level dependencies
└── README.md              # Project documentation
```

### Key Dependencies
```kotlin
// Core Android libraries
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("com.google.android.material:material:1.11.0")

// Navigation components
implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

// Image loading
implementation("com.github.bumptech.glide:glide:4.16.0")

// UI components
implementation("androidx.recyclerview:recyclerview:1.3.2")
implementation("androidx.viewpager2:viewpager2:1.0.0")
```

## 🎯 Business Model

### Revenue Stream
- **Visiting Charges**: ₹50 standard fee for provider visits
- **Commission**: Potential future commission on completed services
- **Premium Listings**: Enhanced visibility for service providers

### Value Proposition
- **For Customers**: Easy access to verified local service providers
- **For Providers**: Platform to reach new customers and grow their business
- **Transparency**: Clear pricing and direct communication

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or newer
- Android SDK 24+ (Android 7.0)
- Kotlin support enabled

### Installation
1. Clone the repository
```bash
git clone https://github.com/yourusername/serviceconnect-android.git
```

2. Open the project in Android Studio

3. Sync project with Gradle files

4. Run the app on an emulator or physical device

### Next Steps for Development
1. Implement backend API integration
2. Add user authentication (phone/email)
3. Integrate payment gateway for visiting charges
4. Implement real-time chat functionality
5. Add location services and mapping
6. Set up push notifications
7. Implement image upload and storage
8. Add review and rating system

## 🎨 UI Components Created

### Layouts
- ✅ Splash Screen (`activity_splash.xml`)
- ✅ Main Activity with Bottom Navigation (`activity_main.xml`)
- ✅ Home Fragment (`fragment_home.xml`)
- ✅ Search Screen (`activity_search.xml`)
- ✅ Provider Profile (`activity_provider_profile.xml`)
- ✅ Chat Interface (`activity_chat.xml`)
- ✅ Booking Screen (`activity_booking.xml`)
- ✅ My Bookings (`fragment_bookings.xml`)
- ✅ User Profile (`fragment_profile.xml`)
- ✅ Provider Signup (`activity_provider_signup.xml`)
- ✅ Terms & Conditions (`activity_terms_conditions.xml`)

### Item Layouts
- ✅ Service Category Cards (`item_service_category.xml`)
- ✅ Provider Cards (`item_provider_card.xml`)
- ✅ Booking Items (`item_booking.xml`)
- ✅ Chat Messages (`item_chat_message.xml`)

### Resources
- ✅ Comprehensive color scheme
- ✅ String resources for all UI text
- ✅ Navigation menus and color selectors
- ✅ Status badge backgrounds

## 🔧 Customization

The app is designed to be easily customizable:

### Colors
Edit `app/src/main/res/values/colors.xml` to change the color scheme:
```xml
<color name="primary_blue">#2196F3</color>
<color name="accent_orange">#FF5722</color>
```

### Strings
All text is externalized in `app/src/main/res/values/strings.xml` for easy localization.

### Layouts
Each screen uses modular, reusable components that can be easily modified or extended.

## 📱 Screenshots
*Screenshots will be added once the app is running*

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

For questions or support, please contact:
- Email: support@serviceconnect.com
- GitHub: [Your GitHub Profile]

---

**Note**: This project currently includes comprehensive UI layouts and designs. Backend integration, authentication, and core business logic implementation are the next development phases.