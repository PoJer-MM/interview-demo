from app.model.user import User

class UserService:

    def __init__(self):
        self.users = [
            User(id=1, name="Tom", age=18)
        ]

    def list_users(self):
        return self.users

    def add_user(self, user: User):
        self.users.append(user)
        return user