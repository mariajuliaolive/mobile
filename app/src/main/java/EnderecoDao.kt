import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EnderecoDao {
    @Insert
    suspend fun salvarEndereco(endereco: EnderecoEntity)

    @Query("SELECT * FROM enderecos")
    suspend fun listarEnderecos(): List<EnderecoEntity>
}
