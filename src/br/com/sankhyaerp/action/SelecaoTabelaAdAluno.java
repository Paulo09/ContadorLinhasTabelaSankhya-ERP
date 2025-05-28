package br.com.sankhyaerp.action;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.extensions.actionbutton.QueryExecutor;
import br.com.sankhya.modelcore.dwfdata.listeners.tsi.AcaoAgendadaListener;

public class SelecaoTabelaAdAluno implements AcaoRotinaJava {

	public Integer result = 0;
	

	@Override
	public void doAction(ContextoAcao contextoacao) throws Exception {
		
		         //Obtemos uma consulta para buscar os lançamentos
				QueryExecutor query = contextoacao.getQuery();
				
				query.nativeSelect("SELECT COUNT(*) AS QTD FROM AD_ALUNO");
				
				
				while (query.next()) {

					this.result = query.getInt("QTD");

					if (result == 0) {
						contextoacao.setMensagemRetorno("Não existem mais Alunos na base!");
					}else{
						contextoacao.setMensagemRetorno("Quantidade Alunos Cadastrados:"+result);
					}
				}
								
				
	}

}
