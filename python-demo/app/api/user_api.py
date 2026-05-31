from fastapi import APIRouter
from app.model.user import User
from app.service.user_service import UserService

router = APIRouter()

service = UserService()

@router.get("/users")
def get_users():
    return service.list_users()

@router.post("/users")
def add_user(user: User):
    return service.add_user(user)