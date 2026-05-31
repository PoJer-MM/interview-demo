import { User } from "../model/User";

export class UserService {

    private users: User[] = [
        {
            id: 1,
            name: "Tom",
            age: 18
        }
    ];

    public getAll(): User[] {
        return this.users;
    }

    public save(user: User): User {

        this.users.push(user);

        return user;
    }
}