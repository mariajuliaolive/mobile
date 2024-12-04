import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "enderecos")
data class EnderecoEntity(
    @PrimaryKey val cep: String,
    val logradouro: String,
    val bairro: String,
    val localidade: String,
    val uf: String
)
