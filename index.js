const functions = require("firebase-functions");
const admin = require("firebase-admin");

admin.initializeApp();

const firestore = admin.firestore();

exports.deleteOldRecords = functions.pubsub.schedule("every 24 hours").onRun(async (context) => {
    const currentDate = new Date();
    const thirtyDaysBefore = new Date(currentDate.getTime() - 30 * 24 * 60 * 60 * 1000);
    const snapshot = await firestore.collectionGroup("trips").where("date", "<", thirtyDaysBefore).get();

    const batch = firestore.batch();

    snapshot.docs.forEach((doc) => {
        batch.delete(doc.ref);
    });

    await batch.commit();

    console.log("Deleted old records");
});



