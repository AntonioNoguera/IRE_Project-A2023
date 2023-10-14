const pantallas = {
  dashboard: {
    dishes: [platillo],
    requisicion: [
      {
        id: "number",
        date: "datetime",
        platillos: [
          {
            id: "number",
            elementos_requeridos,
            cantidad_personas: "number",
          },
        ],
      },
    ],
  },
  inventario: {
    requisicion_actual: {
      id: "number",
      date: "datetime",
      elementos: [elementos],
    },
    entrada: [
      {
        id: "number",
        elementos: [elementos],
        date: "datetime",
      },
    ],
  },
  elementos: [
    {
      id: "number",
      name: "string",
      stock: "number",
      unit: "string",
      group: {
        id: "number",
        name: "string",
        description: "string",
        color: "string",
      },
    },
  ],
  platillos: [
    {
      id: "number",
      name: "string",
      //ingredient_list_id: "number",
      ingredient_list: ingredient_list,
    },
  ],
  lista_de_ingredientes: [
    {
      id: "number",
      platillo_id: "number",
      updated_date: "datetime",
      //is_active: "boolean",
      elementos: [
        {
          ...caracteristicas_elementos_requeridos,
          cantidad: "number",
        },
      ],
    },
  ],
  complementos: [
    {
      id: "number",
      name: "string",
      description: "string",
      type: "proteinas | salsas | extra",
    },
  ],
};
