---------------------------------RELATORIO---------------------------------
Visto que o comportamento dos métodos da classe depende de um estado do objeto conta mágica, além dos parâmetros de entrada, entende-se que as técnicas mais apropriadas para prever todas as situações inerentes ao problema seriam : 
 -- Cobertura de Nodo - Para garantir que todos os estados da classe são atingidos sm um dado momento
 -- Cobertura de Arestas - Para garantir que todas as transições de estado estão ocorrendo de maneira adequada
 -- Valor Limite - Para garantir que as contas nunca fiquem negativas. É importante que na hipótese de uma operação tentar gerar um estado inválido , como por exemplo saldo negativo, haja visibilidade da tentativa sem efetivação da operação

Além disso, para blindar os métodos contra erros não relacionados a situações inválidas, mas sim ligados aos métodos de entrada de dados, é relevante testar a identificação e tratamento das exceções. As principais situações que precisam ser tratadas nesse sentido são a passagem de parâmetros inválidos para as operações de depósito e retirada. Considerando que consistência dos tipos de dados são garantidas pela linguagem, resta a preocupação com valores negativos e com situações como o saldo negativo mencionado acima.
De forma a garantir que o sistema seja capaz de identificar quando estas situações ocorrem e não gerem uma operação sem sentido, a classe deve garantir que a exceção seja lançada nessas situações . Visando consistência com as boas práticas modificado o nome INVALID_OPER_EXCEPTION sugerido no enunciado para InvalidOperException.


Inicialmente a classe será desenvolvida sem a preocupação com o lançamento da exceção nas condições apropriadas, porém isso será implementado na sequência. Isso é para permitir que a primeira bateria de testes possa ser feita o quanto antes sem a preocupação de criar os testes para lançamento de exceções que usam mecanismos novos ao grupo.

Após a implementação inicial da classe e de alguns testes intuitivamente feitos no processo de depuração o resultado do CodeCoverage atingiu 69% de cobertura.
Desse total a operação de depósito teve 60% de cobertura e a de retirada 75%.

Observou-se que as linhas não cobertas derivavam do fato de que nos casos de teste iniciais de depuração não previam combinações específicas de estado da conta e valores de depósito e retirada que disparavam a transição de categoria e que não disparavam. Prevendo tal situação já estava planejado seguir a técnica de cobertura de arestas para planejamento dos demais testes.

Observando o código inicial se identificou a possibilidade de eliminar verificações de condição redundantes reordenando o código nos métodos. Neste momento foi também criado o mecanismo de lançamento das exceções mencionadas anteriormente. A reordenação do código diminuiu o número de linhas, facilitando a leitura e reduzindo a quantidade a ser coberta nos testes seguintes.

Com a implementação do lançamento das exceções, foi modificado o comportamento da classe para as situações que gerariam saldo negativo. Antes ela zerava o valor do saldo nessas condições e concluia a operação, e agora passou a reverter ao estado inicial pré-operação e lançar exceção. Os casos de teste criados para o comportamento inicial devem então ser substituídos e os demais readequados para compreender a reversão ao estado inicial na retirada de valores que tornariam saldo negativo. 

Neste segundo momento modificamos os casos de teste para lançar a exceção um nível acima ao invés de tratá-la, para permitir a execução da segunda bateria com dados válidos sem nos preocuparmos ainda com os testes das exceções.

Após a execução da segunda bateria de testes a cobertura subiu para 82% das instruções e 58% dos branches, o que era previsíve visto que o número de branches de condição diminuiu em função da reorganização do código

As linhas que permaneceram sem cobertura foram as que envolviam o lançamento das exceções (como previsto) e as mesmas condições de combinações de estado e valor de saldo final que já haviam sido observadas anteriormente.

Observamos que o conteúdo da primeira execução do CodeCoverage não foi incluso no controle de versão. Então optou-se por incluir a partir deste momento

Na nova bateria de testes incluímos testes para depósitos realizados com a conta no status Platinum, que ainda não estava previsto nos demais testes. Percebemos um erro na regra e foi corrigido.

A bateria seguinte chegou a 86% de cobertura de instruções e 62% dos caminhos de condição. As linhas faltantes ainda são as referentes aos casos que gerariam exceção e as que gerariam redução de categoria

Implementamos os casos de teste para o lançamento de exceções e executamos nova bateria
Resultado de 100% de cobertura de instruções e 75% de branches

Após a inclusão dos casos para testar as demais branches chegamos a 100% de cobertura de instruções e 91% de cobertura de branches.
Com isso percebemos que as branches nao cobertas terminaram de tal forma pois pela lógica dos estados possíveis seria desnecessário validar a última categoria de conta quando todas as demais já foram validadas e não enquadravam. Este teste necessariamente sempre daria verdadeiro, por eliminação.

Optou-se então por remover a verificação desnecessária nessas linhas.
