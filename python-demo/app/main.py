from fastapi import FastAPI
from app.api.user_api import router as user_router

app = FastAPI()

# 注册路由
app.include_router(user_router)

@app.get("/")
def root():
    return {"msg": "python service running"}