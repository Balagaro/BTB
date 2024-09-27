// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyBsi0RGFEvGdg4_6YXl-VeEIQZFR-IBzTY",
    authDomain: "beyondtheblocks-7315f.firebaseapp.com",
    projectId: "beyondtheblocks-7315f",
    storageBucket: "beyondtheblocks-7315f.appspot.com",
    messagingSenderId: "512329579491",
    appId: "1:512329579491:web:b968fe3581121b448afed6",
    measurementId: "G-88M556DC4T"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);