// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyC-BBDNrxUF_AA2XpKXWywP4oBWMcNP43E",
    authDomain: "beyond-the-blocks.firebaseapp.com",
    projectId: "beyond-the-blocks",
    storageBucket: "beyond-the-blocks.appspot.com",
    messagingSenderId: "762335995233",
    appId: "1:762335995233:web:b8e898dcb3560761119120",
    measurementId: "G-X9RZN4W33Q"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);