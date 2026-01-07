# 🧪 Guide de Tests Postman - Microservices

## 📋 Ordre de Tests Recommandé

### ✅ **1. Vérifier Eureka Dashboard**
Ouvrir dans le navigateur : http://localhost:8761

Vous devriez voir tous les services enregistrés :
- API-GATEWAY
- USER-SERVICE  
- PRODUCT-SERVICE
- ORDER-SERVICE
- CONFIG-SERVER

---

## 🔹 **2. Tests USER-SERVICE**

### ➕ Créer un utilisateur
```
POST http://localhost:8001/utilisateurs
Content-Type: application/json

Body (raw JSON):
{
  "nom": "Jean Dupont",
  "email": "jean.dupont@email.com"
}
```
**Résultat attendu** : Status 200, retourne l'utilisateur créé avec son `id`

### 📋 Lister tous les utilisateurs
```
GET http://localhost:8001/utilisateurs
```
**Résultat attendu** : Status 200, liste JSON des utilisateurs

### 🔍 Obtenir un utilisateur par ID
```
GET http://localhost:8001/utilisateurs/1
```
**Résultat attendu** : Status 200, détails de l'utilisateur

---

## 🔹 **3. Tests PRODUCT-SERVICE**

### ➕ Créer un produit
```
POST http://localhost:8002/produits
Content-Type: application/json

Body (raw JSON):
{
  "nom": "Laptop Dell",
  "prix": 899.99
}
```
**Résultat attendu** : Status 200, retourne le produit créé avec son `id`

### 📋 Lister tous les produits
```
GET http://localhost:8002/produits
```

### 🔍 Obtenir un produit par ID
```
GET http://localhost:8002/produits/1
```

---

## 🔹 **4. Tests ORDER-SERVICE**

### ➕ Créer une commande
```
POST http://localhost:8003/commandes
Content-Type: application/json

Body (raw JSON):
{
  "utilisateurId": 1,
  "produitId": 1,
  "quantite": 2
}
```
**Résultat attendu** : Status 200, commande créée avec les détails de l'utilisateur et du produit

### 📋 Lister toutes les commandes
```
GET http://localhost:8003/commandes
```

---

## 🚀 **5. Tests via API GATEWAY (Port 8080)**

Vous pouvez accéder aux mêmes endpoints via l'API Gateway :

### User Service via Gateway
```
POST http://localhost:8080/user-service/utilisateurs
GET http://localhost:8080/user-service/utilisateurs
GET http://localhost:8080/user-service/utilisateurs/1
```

### Product Service via Gateway
```
POST http://localhost:8080/product-service/produits
GET http://localhost:8080/product-service/produits
GET http://localhost:8080/product-service/produits/1
```

### Order Service via Gateway
```
POST http://localhost:8080/order-service/commandes
GET http://localhost:8080/order-service/commandes
```

---

## 🎯 **Scénario Complet de Test**

1. **Créer 2 utilisateurs** → Noter les IDs retournés
2. **Créer 3 produits** → Noter les IDs retournés
3. **Créer plusieurs commandes** en utilisant les IDs collectés
4. **Vérifier les listes** pour confirmer que tout est enregistré

---

## ⚠️ **En cas de problème**

### Vérifier les logs :
```bash
docker-compose logs -f order-service
docker-compose logs -f user-service
docker-compose logs -f product-service
```

### Redémarrer les services :
```bash
docker-compose down
docker-compose up -d
```

### Vérifier l'état des conteneurs :
```bash
docker-compose ps
```

---

## 📊 **Endpoints disponibles**

| Service | Port Direct | Via Gateway |
|---------|------------|-------------|
| Discovery | 8761 | - |
| Config | 8888 | - |
| Gateway | 8080 | - |
| User | 8001 | /user-service |
| Product | 8002 | /product-service |
| Order | 8003 | /order-service |
