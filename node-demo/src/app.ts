import express from "express";
import userRoutes from "./routes/UserRoutes";

const app = express();

app.use(express.json());

app.use(userRoutes);

app.listen(
    3000,
    () => {
        console.log(
            "server started at 3000"
        );
    }
);