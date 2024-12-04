import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EnderecoViewModel(private val enderecoDao: EnderecoDao) : ViewModel() {
    suspend fun buscarCep(cep: String): EnderecoEntity? {
        val resposta = RetrofitClient.api.buscarCep(cep).execute()
        return if (resposta.isSuccessful) {
            resposta.body()?.let {
                val enderecoEntity = EnderecoEntity(
                    it.cep, it.logradouro, it.bairro, it.localidade, it.uf
                )
                enderecoDao.salvarEndereco(enderecoEntity)
                enderecoEntity
            }
        } else null
    }

    suspend fun listarEnderecos(): List<EnderecoEntity> {
        return withContext(Dispatchers.IO) {
            enderecoDao.listarEnderecos()
        }
    }
}
