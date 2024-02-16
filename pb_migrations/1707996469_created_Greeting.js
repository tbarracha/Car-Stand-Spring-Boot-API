/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "9h3h4iqxonqo0zl",
    "created": "2024-02-15 11:27:49.347Z",
    "updated": "2024-02-15 11:27:49.347Z",
    "name": "Greeting",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "zxepnjoc",
        "name": "hello",
        "type": "text",
        "required": false,
        "presentable": false,
        "unique": false,
        "options": {
          "min": null,
          "max": null,
          "pattern": ""
        }
      }
    ],
    "indexes": [],
    "listRule": "",
    "viewRule": null,
    "createRule": null,
    "updateRule": null,
    "deleteRule": null,
    "options": {}
  });

  return Dao(db).saveCollection(collection);
}, (db) => {
  const dao = new Dao(db);
  const collection = dao.findCollectionByNameOrId("9h3h4iqxonqo0zl");

  return dao.deleteCollection(collection);
})
