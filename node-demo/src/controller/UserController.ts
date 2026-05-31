import { Request, Response } from "express";
import { UserService } from "../service/UserService";

const service = new UserService();

export class UserController {

    public getUsers(req: Request, res: Response): void {

        res.json(
            service.getAll()
        );
    }

    public saveUser(req: Request, res: Response): void {

        res.json(
            service.save(req.body)
        );
    }
}