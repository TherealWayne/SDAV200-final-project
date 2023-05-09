import firebase from "firebase/app";
import "firebase/auth";
import "firebase/firestore";

const firebaseConfig = {
    apiKey: "\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDvrw7lTO7GsSTe\nSYupevr4wFlWVH6kuowRkG24W6XmHB6q0ZThyF436N19A6mcTWJ1uUF/E+FDBn4k\nFrkiw7GNX3shFlp5cj+Cx6oLx3jqzxSiSn+nP+lBdyixdHSo/ZPTYCq5KKS17/0I\nUzsBl0zCMYi573Evsi36AcyKB183L04PV3r+7zrY4twpMv8yH/gTSz+6qw24RRoS\nFzVtMrqG2w8TPvWFdIuKGFunT4Vtlgx5JVMi+W56C0WW7PYg/7HlTaH2Is0xf2ud\nO8ZnXbe6TNG8ZPLFSdFFn21JXpOu4nfdKyT4bkxVdioex3voHV1VOnElc4azzmV8\nL/CbN6ErAgMBAAECggEAGSkXojXaQZyqPHTHUXTp0EpjgRmA6zVIq4tYHpNDA2M4\n9kDmpRujMFv57DwB27jlOMBywgP0kKmnfOMEb5l6vlbN68zslcp1elAQEgklhgNT\nrNmvNCppsl1E4KP99G4czNf6hCdiawA/YAFaCge3n2cTGERXbboBnjipdQ/jDJLE\nVlBfn1mFQQH2hV1NWLSxyq5Nh/2HScG6ILDPjJ9ARt/9qmr6paXFilL9iBJy9a14\ndeEZE3IbihlqGJiXndYB81NkrqBW6QjiS4Sjiw9qWtPiBOnf0uEpmv6eoN4Wm7HE\n/7BnvtuFZxLqocewIADr6dbx+Owa1ZglN8Wwv304MQKBgQD8FM2UD2HAafD15Wu7\nDrAmdH0Lp3TDZgrf1lx5lsMhhzmJGF9268O1XRbE6p6OXiZW2rCiBpfaC8eGj/dJ\nSjuGnQBMORUcLJmxUEtupGZVZMYgwExANqKijpSal/K5ATeO3LE9hxv6I4A7Tlk8\n68MgoqFGve8O5rUUCd/cH6+CuQKBgQDzaOrmwo8hWurSdM3s4MpJCqbzQTpC9IeB\nv/rgcx1QtIERS6i9/0Ye3s5ROXLL6l7ZAZDALGy7NZsyit9KfIfrelA8sdb4n8pA\n8K68w4N+SHGcWkHGorXZtONX+j3X9Skw9qZa7Hr7rpf2Adj1Z/PvOHoKEqYBFYmK\nmxl/LClhAwKBgGkbS3SWzU1rXvtIg5jlUPFX1OPNGNR4ccRPHxPbltUeCxFsxjFR\nsLKoc9v7b80w2I+Sc9+7HAngq3siABvhBdzlDcC6dGDg/9x8/FbP2ZN1h18Ujzaf\nEUTyamfjP2OAbGf3ATgEY9fygX849eB+9UdgSBq1Cz6NV6dZTqv70jSRAoGAQjQa\nF9N5HIhe8Ajm7XOicUVdbTIjh4x8wrSVprCIm6fMpwieB7dDuie9k+f9Kis/yuQb\nG7m5hR2qbY/J9bdzPH/TDP8Nyiej2g/cZukCfbl0dSMzWrRso58IaqhcY72Bi5i6\nXGaPeJ7fJAESooS4mysQPmceEZNrCnDu+WDojEMCgYBdJE/RX9jr2r6JRcTgSXNc\nWbkfOB8gwt046VtKrqtEVN8RUNaBV/JVhJgHVONHRGIAdhirH7L4z2C9JAsZuwV7\np0kmArRFYJ5rJ34Us3kU/HbStnaH2EiqM71IETGWF2pUWDevzcVyvrToZYZd9Csu\nXrgN2KEMlthvV7CapTuzsQ==\n-----END PRIVATE KEY-----\n",
    authDomain:  "https://accounts.google.com/o/oauth2/auth",
    projectId: "final-project-svad150",
    storageBucket: "final-project-svad150.appspot.com",
    messagingSenderId: "1029586309290",
    appId: "1:1029586309290:web:6b0b0b0b0b0b0b0b0b0b0b",
    measurementId: "G-0B0B0B0B0B"
    
};

firebase.initializeApp(firebaseConfig);

const auth = firebase.auth();
const firestore = firebase.firestore();

export { auth, firestore };




