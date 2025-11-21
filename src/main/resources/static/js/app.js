// URL base del backend de recetas
const API_URL = 'http://localhost:8082/api/recetas'; // Ajusta el puerto si es diferente

// Función para obtener todas las recetas
async function obtenerRecetas() {
    try {
        const response = await fetch(API_URL);
        
        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }
        
        const recetas = await response.json();
        console.log('Recetas obtenidas:', recetas);
        return recetas;
    } catch (error) {
        console.error('Error al obtener recetas:', error);
        return [];
    }
}

// Función para mostrar las recetas en el HTML
async function mostrarRecetas() {
    const recetas = await obtenerRecetas();
    const container = document.getElementById('recetas-container');
    
    if (recetas.length === 0) {
        container.innerHTML = '<p>No hay recetas disponibles</p>';
        return;
    }
    
    container.innerHTML = recetas.map(receta => `
        <div class="receta-card">
            <h3>${receta.nombre}</h3>
            <p><strong>Ingredientes:</strong> ${receta.ingredientes}</p>
            <p><strong>Preparación:</strong> ${receta.preparacion}</p>
            <p><strong>Calorías:</strong> ${receta.calorias} kcal</p>
        </div>
    `).join('');
}

async function cargarRecetas() {
    try {
        let tInicio = performance.now();
        const res = await fetch(API_URL);

        console.log("URL solicitada:", API_URL);
        console.log("Método usado: GET");
        console.log("Código de estado:", res.status);
        console.log("Tiempo de respuesta:", performance.now() - tInicio, "ms");

        const data = await res.json();

        let tbody = document.querySelector("#tablaRecetas tbody");
        tbody.innerHTML = "";

        data.forEach(r => {
            tbody.innerHTML += `
                <tr>
                    <td>${r.id}</td>
                    <td>${r.nombre}</td>
                    <td>${r.descripcion}</td>
                    <td>
                        <button class="btnEditar" onclick="cargarParaEditar(${r.id}, '${r.nombre}', '${r.descripcion}')">Editar</button>
                        <button class="btnEliminar" onclick="eliminarReceta(${r.id})">Eliminar</button>
                    </td>
                </tr>
            `;
        });

    } catch (e) {
        console.log("ERROR EN PETICIÓN:", e);
        alert("Error al cargar recetas");
    }
}
