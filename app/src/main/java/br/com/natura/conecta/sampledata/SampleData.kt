package br.com.natura.conecta.sampledata

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import br.com.natura.conecta.R
import br.com.natura.conecta.model.Cart
import br.com.natura.conecta.model.Consultant
import br.com.natura.conecta.model.Info
import br.com.natura.conecta.model.Level
import br.com.natura.conecta.model.OnBoardingPage
import br.com.natura.conecta.model.Order
import br.com.natura.conecta.model.PickUpPoint
import br.com.natura.conecta.model.Product
import br.com.natura.conecta.model.Question
import br.com.natura.conecta.model.Tip
import br.com.natura.conecta.model.enums.Levels
import br.com.natura.conecta.model.enums.OrderType
import com.google.android.gms.maps.model.LatLng
import java.math.BigDecimal
import java.time.LocalTime
import java.util.Date

var isHomeLoaded = false
var isShopLoaded = false
var isCommunityLoaded = false

var sampleBanners = listOf(
    R.drawable.banner_1,
    R.drawable.banner_2,
    R.drawable.banner_3,
    R.drawable.banner_4,
)

var sampleInfos = listOf(
    Info(
        title = "Consultoria de Beleza",
        text = "Descubra oportunidades e dicas para mandar bem na consultoria!",
        image = R.drawable.infocard_1
    ),
    Info(
        title = "Novidades da Semana",
        text = "Confira todas as promoções da semana que preparamos para você!",
        image = R.drawable.infocard_2
    ),
    Info(
        title = "#CoragemDeMulher",
        text = "Encontre histórias de coragem e determinação que inspiram o bem estar bem!",
        image = R.drawable.infocard_3
    )
)

val sampleProducts = listOf(
    Product(
        name = "Essencial Oud Masculino 100 ml",
        description = "Deo parfum Essencial Oud Natura amadeirado intenso\n\n" +
                "A imponência do Oud, madeira mais nobre do mundo, com a sensualidade da copaíba, uma madeira da biodiversidade brasileira, realçadas com um toque exótico de especiarias neste autêntico Deo Parfum Natura amadeirado. Instiga ao mesmo tempo que conquista.",
        purchasePrice = BigDecimal(259.90 * 0.75),
        salePrice = BigDecimal(259.90),
        image = R.drawable.essencial_oud_masculino_100_ml,
        points = 34
    ),
    Product(
        name = "Batom CC Hidratante FPS 25 Una Rouge",
        description = "Com uma variedade de cores, o Batom Natura Una também conta com 10 benefícios para seus lábios:\n" +
                "\n" +
                "• Alta cobertura;\n" +
                "• Longa duração;\n" +
                "• Recupera a firmeza dos lábios*;\n" +
                "• Reduz linhas*;\n" +
                "• Uniformiza a textura dos lábios*;\n" +
                "• Hidrata por 24h;\n" +
                "• Recupera a maciez;\n" +
                "• Aumenta o volume;\n" +
                "• Ação antissinais, com proteção UVA e FPS25;\n" +
                "• Acabamento cremoso.\n" +
                "\n" +
                "* Benefícios obtidos com o uso contínuo do produto.",
        purchasePrice = BigDecimal(49.90 * 0.80),
        salePrice = BigDecimal(49.90),
        image = R.drawable.batom_cc_hidratante_fps_25_una_rouge,
        points = 7
    ),
    Product(
        name = "Luna Ilumina 50 ml",
        description = "Realça o brilho de cada mulher\n\n" +
                "Luna Ilumina Deo Parfum é uma fragrância intensa e elegante que realça o brilho próprio de cada mulher. Unimos a releitura do chipre criado por nossa perfumista exclusiva à luxuosa Flor do Açafrão e ao Novo Breu, ingrediente da biodiversidade brasileira extraído por uma comunidade fundada por mulheres.",
        purchasePrice = BigDecimal(194.90 * 0.75),
        salePrice = BigDecimal(194.90),
        image = R.drawable.luna_ilumina_50_ml,
        points = 26
    ),
    Product(
        name = "Mamãe e Bebê Água de Colônia 100 ml",
        description = "Cheirinho de bebê, amor, carinho e cuidado.\n" +
                "Fórmula 100% segura para ser usada desde o primeiro dia de vida, testada e aprovada por pediatras. Com perfumação suave, sem álcool para não agredir a pele sensível e delicada do bebê.\n\n" +
                "Benefícios:\n\n" +
                "• Perfumação suave, sem álcool;\n\n" +
                "• Testada e aprovada por pediatras;\n\n" +
                "• 89% dos ingredientes naturais;\n\n" +
                "• Produto vegano.\n\n" +
                "Conteúdo: 100ml.",
        purchasePrice = BigDecimal(98.90 * 0.75),
        salePrice = BigDecimal(98.90),
        image = R.drawable.mam_e_e_beb___gua_de_col_nia_100_ml,
        points = 13
    ),
    Product(
        name = "Creme Nutritivo Para o Corpo Tododia Cereja e Avelã",
        description = "A sua fragrância favorita voltou: atraente e marcante que combina o frutal da cereja com notas adocicadas.\n\n" +
                "Sinta seu corpo com o novo Creme Nutritivo Desodorante Tododia Cereja e Avelã. Uma combinação balanceada de ingredientes naturais com NUTRIÇÃO PREBIÓTICA, que se adapta ao que sua pele precisa a cada dia. Por isso, esse creme é indicado para todos os tipos de pele.",
        purchasePrice = BigDecimal(39.45 * 0.70),
        salePrice = BigDecimal(39.45),
        image = R.drawable.creme_nutritivo_para_o_corpo_tododia_cereja_e_avel_,
        points = 5
    ),
    Product(
        name = "Sabonete Mamãe e Bebê",
        description = "Sabonete Natura Mamãe e Bebê: Limpeza delicada desde o primeiro banho\n\n" +
                "O banho, esse pequeno grande momento diário de cuidado com o bebê, ajuda a fortalecer ainda mais o amor. A fórmula vegana do Sabonete Mamãe e Bebê contém somente o essencial para limpar de forma suave e delicada a pele sensível do bebê. Não resseca a pele e é tão seguro que pode ser usado desde o primeiro banho.",
        purchasePrice = BigDecimal(43.90 * 0.80),
        salePrice = BigDecimal(43.90),
        image = R.drawable.sabonete_mam_e_e_beb_,
        points = 6
    ),
    Product(
        name = "Meu Primeiro Humor Feminino 75 ml",
        description = "Fragrância Meu Primeiro Humor: Ousadia e diversão em cada nota\n\n" +
                "A fragrância frutal de Meu Primeiro Humor é uma forma única de encarar a vida, convidando-nos a quebrar a seriedade do cotidiano de maneira ousada e divertida: um aroma que convida a espalhar alegria. A combinação de notas cítricas e um coquetel de frutas vibrantes, contrastados com um irresistível toque de frozen de pera, resulta em uma fragrância irreverente. Enriquecida com priprioca, um ingrediente natural da biodiversidade brasileira, a fragrância Primeiro Humor é o primeiro e inconfundível queridinho da linha.",
        purchasePrice = BigDecimal(143.90 * 0.75),
        salePrice = BigDecimal(143.90),
        image = R.drawable.meu_primeiro_humor_feminino_75_ml,
        points = 19
    ),
    Product(
        name = "Máscara para Cílios Volume Magnífico Lavável Una",
        description = "Una volume customizável a um olhar magnífico\n\n" +
                "Empodere seu olhar e conquiste cílios magníficos, curvados e com até 700% mais volume*. Construa camadas de um efeito natural ao intenso. Volume, definição, alongamento e fórmula ultrapigmentada. Sem formar grumos e sem deixar os cílios grudados**. *Teste instrumental in vitro ** Teste sensorial de consumidor em 120 mulheres, após usar o produto por uma semana.",
        purchasePrice = BigDecimal(79.90 * 0.75),
        salePrice = BigDecimal(79.90),
        image = R.drawable.m_scara_para_c_lios_volume_magn_fico_lav_vel_una,
        points = 11
    ),
    Product(
        name = "Natura Homem Sagaz 100 ml",
        description = "Descubra a Fragrância Amadeirada de Natura Homem Sagaz\n\n" +
                "Apresentamos a você a linha Natura Homem Sagaz, criada especificamente para o homem moderno que valoriza a sua individualidade. Esta linha completa de perfumaria e cuidados pessoais permite que cada homem se cuide à sua maneira.",
        purchasePrice = BigDecimal(204.90 * 0.80),
        salePrice = BigDecimal(204.90),
        image = R.drawable.natura_homem_sagaz_100_ml,
        points = 30
    ),
    Product(
        name = "Protetor Clareador FPS 70 Chronos",
        description = "Descubra o Protetor Solar Chronos: Proteção, Clareamento e Cobertura Natural\n\n" +
                "Conheça o Protetor Solar Clareador Natura Chronos, um aliado indispensável para a saúde e beleza da sua pele. Além de oferecer proteção contra os raios UVB e UVA, este Protetor Solar Clareador também uniformiza o tom da pele, clareando e prevenindo áreas escurecidas. Disponível em duas cores, proporciona uma cobertura natural que disfarça imperfeições, deixando a pele com aparência saudável e revitalizada. Com o Protetor Solar Natura Chronos, você pode curtir o sol com confiança e cuidado.",
        purchasePrice = BigDecimal(107.90 * 0.70),
        salePrice = BigDecimal(107.90),
        image = R.drawable.protetor_clareador_fps_70_chronos,
        points = 14
    )
)

val sampleTips = listOf(
    Tip(
        title = "Consultoria de beleza",
        text = "Transforme sua paixão por beleza em sucesso, vamos promover o bem estar bem!",
        image = R.drawable.tipcard_1
    ),
    Tip(
        title = "Treinamentos",
        text = "Participe de nossos treinamentos e domine o mundo das vendas de beleza!",
        image = R.drawable.tipcard_2
    )
)

val sampleConsultants = listOf(
    Consultant(
        name = "Nilsa Souza",
        city = "São Luís",
        state = "MA",
        level = "Diamante",
        position = "1",
        points = "415",
        image = R.drawable.woman1
    ),
    Consultant(
        name = "Patrícia Matos",
        city = "São Paulo",
        state = "SP",
        level = "Ouro",
        position = "2",
        points = "411",
        image = R.drawable.woman2
    ),
    Consultant(
        name = "Angelica Ramos",
        city = "Natal",
        state = "RN",
        level = "Diamante",
        position = "3",
        points = "409",
        image = R.drawable.woman3
    )
)

var samplePickUpPoints: List<PickUpPoint> = listOf()

fun getSurroundingPoints(center: LatLng): List<PickUpPoint> {
    samplePickUpPoints = listOf(
        PickUpPoint(
            name = "Loja Natura Bourbom",
            evaluation = "4.9",
            position = LatLng(center.latitude + 0.003, center.longitude + 0.003),
            image = R.drawable.natura_store1,
            icon = R.drawable.ic_map_natura_store,
            closeHour = 19,
            evaluationNumber = 2.2F
        ),
        PickUpPoint(
            name = "Loja Encanto Verde",
            evaluation = "4.8",
            position = LatLng(center.latitude - 0.017, center.longitude + 0.02),
            image = R.drawable.partner_store1,
            icon = R.drawable.ic_map_partner_store,
            closeHour = 18,
            evaluationNumber = 2.0F
        ),
        PickUpPoint(
            name = "Cantina Dona Maria",
            evaluation = "4.7",
            position = LatLng(center.latitude - 0.012, center.longitude - 0.006),
            image = R.drawable.partner_store2,
            icon = R.drawable.ic_map_partner_store,
            closeHour = 20,
            evaluationNumber = 1.7F
        ),
        PickUpPoint(
            name = "Loja Natura Plaza Shopping",
            evaluation = "5.0",
            position = LatLng(center.latitude - 0.0013, center.longitude - 0.025),
            image = R.drawable.natura_store2,
            icon = R.drawable.ic_map_natura_store,
            closeHour = 18,
            evaluationNumber = 1.2F
        ),
        PickUpPoint(
            name = "Floricultura Primavera",
            evaluation = "4.6",
            position = LatLng(center.latitude + 0.02, center.longitude + 0.003),
            image = R.drawable.partner_store3,
            icon = R.drawable.ic_map_partner_store,
            closeHour = 16,
            evaluationNumber = 1.0F
        )
    )
    return samplePickUpPoints
}

val cart: Cart = Cart()
var orderChose: Order? = null
var orderFinished: Order? = null

val consultant = Consultant(
    name = "Helena Dias",
    city = "Rio de Janeiro",
    state = "RJ",
    level = "Semente",
    position = "28",
    points = "252",
    image = R.drawable.consultant_user_photo
)

@RequiresApi(Build.VERSION_CODES.O)
var sampleOrders = listOf(
    Order(
        consultants = sampleConsultants,
        type = OrderType.MÍNIMO,
        lastTime = LocalTime.now().plusHours(1),
        points = 26,
        totalProducts = 6,
        totalPrice = BigDecimal(122.50),
        date = Date(2024,8, 7)
    ),
    Order(
        consultants = sampleConsultants,
        type = OrderType.MÍNIMO,
        lastTime = LocalTime.now().minusHours(10),
        points = 37,
        totalProducts = 12,
        totalPrice = BigDecimal(155.23),
        date = Date(2024,8, 3)
    ),
    Order(
        consultants = sampleConsultants,
        type = OrderType.MÍNIMO,
        lastTime = LocalTime.now().minusHours(2),
        points = 40,
        totalProducts = 10,
        totalPrice = BigDecimal(250.23),
        date = Date(2024,8, 30)
    ),
    Order(
        consultants = sampleConsultants,
        type = OrderType.CLÁSSICO,
        lastTime = LocalTime.now().minusHours(4),
        points = 120,
        totalProducts = 21,
        totalPrice = BigDecimal(399.90),
        date = Date(2024,8, 15)
    ),
    Order(
        consultants = sampleConsultants,
        type = OrderType.EXECUTIVO,
        lastTime = LocalTime.now().plusHours(2),
        points = 326,
        totalProducts = 40,
        totalPrice = BigDecimal(800.21),
        date = Date(2024,8, 12)
    ),
    Order(
        consultants = sampleConsultants,
        type = OrderType.EXECUTIVO,
        lastTime = LocalTime.now().minusHours(3),
        points = 403,
        totalProducts = 32,
        totalPrice = BigDecimal(914.45),
        date = Date(2024,8, 27)
    )
)

val sampleQuestions = listOf(
    Question(
        question = "Quantas compras coletivas posso fazer por ciclo?",
        answer = "Cada consultora pode fazer apenas uma compra coletiva por ciclo."
    ),
    Question(
        question = "O que acontece se a compra coletiva não for concluída em 48 horas?",
        answer = "A compra coletiva será cancelada se não for concluída em 48 horas."
    ),
    Question(
        question = "O que são pontos de uma compra coletiva e como eles funcionam?",
        answer = "Pontos são metas que precisam ser atingidas para concluir uma compra coletiva."
    ),
    Question(
        question = "Posso editar meu carrinho após fechá-lo?",
        answer = "Sim, basta ir a sessão do carrinho e clicar no botão 'Editar carrinho'"
    ),
    Question(
        question = "Como convido outras consultoras para minha compra coletiva?",
        answer = "Use a opção 'Convide outras consultoras!' na tela de compras coletivas, ou acesse sua compra na tela de pedidos e compartilhe com outras consultoras."
    ),
    Question(
        question = "Como sei se minha compra atingiu os pontos necessários?",
        answer = "Você será notificada quando sua compra atingir os pontos necessários e for fechada."
    ),
    Question(
        question = "Posso escolher o ponto de retirada?",
        answer = "Sim, você pode escolher o ponto de retirada ao finalizar a compra."
    ),
    Question(
        question = "Como acompanho o status da minha compra coletiva?",
        answer = "Você pode acompanhar o status na aba de pedidos do aplicativo."
    ),
    Question(
        question = "O que faço se tiver um problema com minha compra coletiva?",
        answer = "Entre em contato com o suporte através da seção de ajuda do aplicativo."
    ),
    Question(
        question = "O que faço se precisar cancelar uma compra coletiva?",
        answer = "Para cancelar uma compra coletiva, acesse a aba de pedidos e selecione a opção de cancelamento antes que o prazo de 48 horas se esgote."
    ),
)

val onBoardingPages = listOf(
    OnBoardingPage(
        title = "Seja bem-vinda ao App Conecta!",
        description = "Realize seus pedidos em parceria com outras consultoras de forma simples!",
        image = R.drawable.onboarding_image1
    ),
    OnBoardingPage(
        title = "Escolha seus produtos",
        description = "Selecione os produtos que promovem o seu bem estar e o bem estar do mundo.",
        image = R.drawable.onboarding_image2
    ),
    OnBoardingPage(
        title = "Adicione-os ao carrinho",
        description = "Adicione seus produtos ao carrinho em poucos toques facilmente!",
        image = R.drawable.onboarding_image3
    ),
    OnBoardingPage(
        title = "Escolha um ponto de retirada",
        description = "Escolha o ponto de retirada mais conveniente e pronto, simples como deve ser.",
        image = R.drawable.onboarding_image4
    )
)

val sampleLevels = listOf(
    Level(
        level = Levels.SEMENTE,
        storeGain = 20,
        onlineGain = 12,
        rewards = null,
        minPoints = 50,
        maxPoints = 299,
        color = Color(0xFF857b74)
    ),
    Level(
        level = Levels.BRONZE,
        storeGain = 30,
        onlineGain = 14,
        rewards = null,
        minPoints = 300,
        maxPoints = 899,
        color = Color(0xFF99715c)
    ),
    Level(
        level = Levels.PRATA,
        storeGain = 30,
        onlineGain = 16,
        rewards = "Joias e Presentes",
        minPoints = 900,
        maxPoints = 2199,
        color = Color(0xFF8a8b8e)
    ),
    Level(
        level = Levels.OURO,
        storeGain = 32,
        onlineGain = 18,
        rewards = "Joias, Presentes e Viagens",
        minPoints = 2200,
        maxPoints = 5499,
        color = Color(0xFF9d8964)
    ),
    Level(
        level = Levels.DIAMANTE,
        storeGain = 35,
        onlineGain = 20,
        rewards = "Joias, Presentes e Viagens",
        minPoints = 5500,
        maxPoints = null,
        color = Color(0xFF849dad)
    ),
)