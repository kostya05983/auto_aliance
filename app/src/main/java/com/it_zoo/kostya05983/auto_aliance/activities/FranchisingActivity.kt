package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.it_zoo.kostya05983.auto_aliance.Franchising.DataFirstSectionUi_Franchising
import com.it_zoo.kostya05983.auto_aliance.Franchising.DataFranchisinGrid
import com.it_zoo.kostya05983.auto_aliance.Franchising.DataSecondSectionUi_Franchising
import com.it_zoo.kostya05983.auto_aliance.R

class FranchisingActivity : AbstractNavigation() {
    private val collectionfirstParagraphs : MutableList<DataFirstSectionUi_Franchising> = mutableListOf()
    private val collectionSecondParagraphs : MutableList<DataSecondSectionUi_Franchising> = mutableListOf()
    private val collectionAgry: MutableList<DataFranchisinGrid> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_franchising)

        fillFirstParagraphsCollection()
        fillSecondParagraphsCollection()
        fillOfOurPoints()

    }
    private fun fillFirstParagraphsCollection(){
        collectionfirstParagraphs.add(0,
                DataFirstSectionUi_Franchising(
                        "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                        "Размещение на основном сайте и корпоративный чат 24\\7",
                        "Использование диспетчерской службы 8 - 800",
                        "GPS - трекинг транспорта",
                        "CRM - система индивидуально на город",
                        "Рекламные акции и материалы для продвижения",
                        null,
                        null,
                        null,
                        null
                )
        )
        collectionfirstParagraphs.add(1,
                DataFirstSectionUi_Franchising(
                        "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                        "Размещение на основном сайте и корпоративный чат 24\\7",
                        "Использование диспетчерской службы 8 - 800",
                        "GPS - трекинг транспорта",
                        "Доступ к CRM вашего города",
                        "Рекламные акции и материалы для продвижения",
                        "Офис в фирменном стиле",
                        "Программа \"Авто+1\"",
                        "1 автомобиль сразу",
                        null
                )
        )
        collectionfirstParagraphs.add(2,
                DataFirstSectionUi_Franchising(
                        "Помощь в открытии юридического лица(бухгалтерская и юридическая поддержка на срок договора).",
                        "Размещение на основном сайте и корпоративный чат 24\\7",
                        "Использование диспетчерской службы 8 - 800",
                        "GPS - трекинг транспорта",
                        "Доступ к CRM вашего города",
                        "Рекламные акции и материалы для продвижения",
                        "Фирменный и полностью укомплектованный офис",
                        "Программа \"Авто+1\"",
                        "2 автомобиль сразу",
                        "Вы получаете полностью готовый бизнес по прокату автомобиля Вашем городе, срок окупаемости которого составляет до 11 месяцев"
                )
        )
    }

    private fun fillSecondParagraphsCollection(){
        collectionSecondParagraphs.add(
                0,
                DataSecondSectionUi_Franchising(
                        "Предоставляем доступ к сайту, почте и корп. чату;",
                        "Доступ к CRM-системе Вашего города;",
                        "Диспетчерская и ежедневные заказы;",
                        "Рекламные материалы;",
                        "Обучение и помощь на всех этапах ведения проекта"
                )
                )
        collectionSecondParagraphs.add(
                1,
                DataSecondSectionUi_Franchising(
                        "Регистрируем ваше предприятие;",
                        "Подготавливаем офис к открытию;",
                        "Занимаетесь сбором необходимой информации;",
                        "Знакомство с лизингом и программой \"Авто+1\";",
                        "Обучение и помощь на всех этапах ведения проекта"
                )
        )
    }

    private fun fillOfOurPoints(){
       collectionAgry.add(
               0,
               DataFranchisinGrid(
                       "\"Авто 99\"",
                       "Стоимость 99 000 рублей",
                       collectionfirstParagraphs[0],
                       "При выборе данной программы: ",
                        collectionSecondParagraphs[0],
                       " 99 000 рублей.",
                       " 1 500 рублей/автомобиль.",
                       "(Исключительно после обучения и запуска бизнеса)"
               )
               )
        collectionAgry.add(
                1,
                DataFranchisinGrid(
                        "\"Авто 149\"",
                        "Стоимость 149 000 рублей",
                        collectionfirstParagraphs[1],
                        "При выборе данной программы: ",
                        collectionSecondParagraphs[1],
                        " 149 000 рублей.",
                        " 1 500 рублей/автомобиль.",
                        null
                )
        )

        collectionAgry.add(
                2,
                DataFranchisinGrid(
                        "\"Авто 249\"",
                        "Стоимость 249 000 рублей",
                        collectionfirstParagraphs[2],
                        null,
                        null,
                        " 249 000 рублей.",
                        " 1 500 рублей/автомобиль.",
                        "Ваша прибыль составит: не менее 150 000 рублей чистого дохода в месяц (к расчёту взято направление проката авто без дополнительных программ)"
                )
        )
        collectionAgry.add(
                3,
                DataFranchisinGrid(
                        "\"Инвестор\"",
                        null,
                        null,
                        "Индивидуальные условия инвестирования в прибыльное направление автопроката с фиксированной процентной ставкой.",
                        null,
                        "Обеспечение инвестирования имуществом на весь срок договора.",
                        "Сумма инвестирования от 2илн. рублей.",
                        "Срок договора 12 месяцев с последующей пролонгацией."
                )
        )
    }

    /*inner class FranshingAdapter(private val mContext: Context) : BaseAdapter(){
        override fun getItemId(p0: Int): Long {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItem(p0: Int): Any {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var grid: View
            if( convertView == null) {
                grid = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                grid = inflater.inflate(R.layout.activity_franchising,parent,false)
            } else {
                grid = convertView
            }
        }
    }*/
}
