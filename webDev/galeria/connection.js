const MongoClient = require('mongodb').MongoClient;

const uri = "mongodb://localhost:27017/";
const client = new MongoClient(uri);

async function run() {
    try {
        await client.connect();
        const database = client.db("GaleriaDB");
        const users = database.collection("Users");
        
        
        const docs = [
            {
                imie: "Imej",
                nazwisko: "Matuszewski",
            },
            {
                imie: "Anna",
                nazwisko: "Kowalska",
            },
            {
                imie: "Jan",
                nazwisko: "Nowak",
            },
            {
                imie: "Patryk",
                nazwisko: "Popek",
            },
            {
                imie: "Jonh",
                nazwisko: "Smith",
            }
            
        ];

        const result = await users.insertMany(docs);
        
    } finally {
        await client.close();
    }
}

run().catch(console.dir);