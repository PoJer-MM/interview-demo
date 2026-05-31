import { Router } from "express";
import { UserController } from "../controller/UserController";

const router = Router();

const controller = new UserController();

router.get(
    "/users",
    controller.getUsers
);

router.post(
    "/users",
    controller.saveUser
);

export default router;