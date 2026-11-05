package com.example.proyectoandroid

import androidx.compose.ui.graphics.Color

sealed class Prioridad(val nombre: String) {
    object Baja : Prioridad("Baja")
    object Media : Prioridad("Media")
    object Alta : Prioridad("Alta")
}
sealed class Estado(val nombre: String) {
    object Pendiente : Estado("Pendiente")
    object Completado : Estado("Completado")
    object Vencido : Estado("Vencido")
}

data class Categoria(val nombre: String)

data class Recordatorio(
    val id: Int,
    val titulo: String,
    val descripcion: String? = null,
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: Estado
)

val trabajo = Categoria("Trabajo")
val estudio = Categoria("Estudio")
val hogar = Categoria("Hogar")
val salud = Categoria("Salud")

val categorias: Set<Categoria> = setOf(trabajo, estudio, hogar, salud, trabajo)

val coloresCategoria: Map<Categoria, Color> = mapOf(
    trabajo to Color(0xFF90CAF9),  // azul cielo
    estudio to Color(0xFFCE93D8),  // lila (el morado)
    hogar to Color(0xFFA5D6A7),    // verde menta
    salud to Color(0xFFFFCC80)     // durazno
)

val recordatorios: List<Recordatorio> = listOf(
    Recordatorio(1, "Entregar informe", "Enviar antes de las 5 pm", trabajo, Prioridad.Alta, Estado.Pendiente),
    Recordatorio(2, "Estudiar", null, estudio, Prioridad.Media, Estado.Pendiente),
    Recordatorio(3, "Comprar verduras", "Feria del sábado", hogar, Prioridad.Baja, Estado.Completado),
    Recordatorio(4, "Control médico", null, salud, Prioridad.Alta, Estado.Vencido),
    Recordatorio(5, "Reunión de equipo", "Sala 2", trabajo, Prioridad.Media, Estado.Pendiente)
)

val pendientes = recordatorios.filter { it.estado == Estado.Pendiente }
val altaPrioridad = recordatorios.filter { it.prioridad == Prioridad.Alta }